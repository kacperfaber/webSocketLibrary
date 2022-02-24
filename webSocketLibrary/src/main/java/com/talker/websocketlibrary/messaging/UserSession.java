package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    final String userId;
    private final List<WebSocketSession> sessions;

    public UserSession(String userId, List<WebSocketSession> sessions) {
        this.userId = userId;
        this.sessions = sessions;
    }

    public void addSession(WebSocketSession webSocketSession) {
        sessions.add(webSocketSession);
    }

    public List<WebSocketSession> getSessions() {
        return new ArrayList<>(sessions);
    }
}
