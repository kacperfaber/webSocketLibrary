package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketSession;

public class Session {
    final String sessionId;
    final WebSocketSession session;
    String userId;

    public Session(String sessionId, WebSocketSession session) {
        this.sessionId = sessionId;
        this.session = session;
    }

    public String getSessionId() {
        return sessionId;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
