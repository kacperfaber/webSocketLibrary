package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    final String userId;
    private final List<WebSocketSession> sessions = new ArrayList<>();

    public UserSession(String userId) {
        this.userId = userId;
    }

    public void addSession(WebSocketSession webSocketSession) {
        sessions.add(webSocketSession);
    }

    public List<WebSocketSession> getSessions() {
        return new ArrayList<>(sessions);
    }
}
