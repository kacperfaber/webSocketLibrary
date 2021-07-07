package com.talker.websocketlibrary.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.util.List;

@Component
public class BaseMessageHandler implements WebSocketHandler {
    IHandlerEventGenerator handlerEventGenerator;
    List<IEventHandler> eventHandlers;

    public BaseMessageHandler(IHandlerEventGenerator handlerEventGenerator, List<IEventHandler> eventHandlers) {
        this.handlerEventGenerator = handlerEventGenerator;
        this.eventHandlers = eventHandlers;
    }

    void handle(WebSocketSession session, WebSocketMessage message, CloseStatus status, HandlerEventKind handlerEventKind) {
        final HandlerEvent handlerEvent = handlerEventGenerator.generate(session, message, status, handlerEventKind);
        for (IEventHandler handler : eventHandlers) {
            if (handler.canHandle(handlerEvent)){
                handler.handle(handlerEvent);
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        handle(webSocketSession, null, null, HandlerEventKind.Connected);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        handle(webSocketSession, webSocketMessage, null, HandlerEventKind.MessageReceived);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        handle(webSocketSession, null, null, HandlerEventKind.Error);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        handle(webSocketSession, null, closeStatus, HandlerEventKind.Disconnected);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
