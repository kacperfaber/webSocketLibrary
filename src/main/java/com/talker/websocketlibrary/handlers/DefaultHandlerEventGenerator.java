package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.messaging.SessionService;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class DefaultHandlerEventGenerator implements IHandlerEventGenerator {
    SessionService sessionService;

    public DefaultHandlerEventGenerator(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public HandlerEvent generate(WebSocketSession session, WebSocketMessage message, CloseStatus closeStatus, HandlerEventKind handlerEventKind) {
        String nullableUserId = sessionService.getUserId(session).orElse(null);
        return new HandlerEvent(handlerEventKind, session, closeStatus, message, nullableUserId);
    }
}
