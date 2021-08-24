package com.talker.websocketlibrary.handlers;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Optional;

public class HandlerEvent {
    WebSocketSession session;
    CloseStatus closeStatus;
    WebSocketMessage message;
    HandlerEventKind kind;
    Object authenticatedUserId;

    public Optional<Object> getAuthenticatedUserId() {
        return Optional.ofNullable(authenticatedUserId);
    }

    public boolean isAuthenticated() {
        return authenticatedUserId != null;
    }

    public HandlerEvent(HandlerEventKind handlerEventKind, WebSocketSession session, CloseStatus closeStatus, WebSocketMessage message, Object authenticatedUserId) {
        this.kind = handlerEventKind;
        this.session = session;
        this.closeStatus = closeStatus;
        this.message = message;
        this.authenticatedUserId = authenticatedUserId;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public Optional<CloseStatus> getCloseStatus() {
        return Optional.of(closeStatus);
    }

    public Optional<WebSocketMessage> getMessage() {
        return Optional.of(message);
    }

    public HandlerEventKind getKind() {
        return kind;
    }
}
