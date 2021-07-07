package com.talker.websocketlibrary.handlers;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public interface IHandlerEventGenerator {
    HandlerEvent generate(WebSocketSession session, WebSocketMessage message, CloseStatus closeStatus, HandlerEventKind handlerEventKind);
}
