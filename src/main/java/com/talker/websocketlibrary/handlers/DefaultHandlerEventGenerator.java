package com.talker.websocketlibrary.handlers;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class DefaultHandlerEventGenerator implements IHandlerEventGenerator{
    @Override
    public HandlerEvent generate(WebSocketSession session, WebSocketMessage message, CloseStatus closeStatus) {
        // TODO: I need to get authentication of session.
        throw new UnsupportedOperationException();
    }
}
