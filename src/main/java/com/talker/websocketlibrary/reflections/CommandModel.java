package com.talker.websocketlibrary.reflections;

import org.springframework.web.socket.WebSocketSession;

import java.util.Optional;

public class CommandModel {
    boolean isAuthenticated;
    String userId, name, data;
    WebSocketSession webSocketSession;

    public CommandModel(boolean isAuthenticated, String userId, String name, String data, WebSocketSession webSocketSession) {
        this.isAuthenticated = isAuthenticated;
        this.userId = userId;
        this.name = name;
        this.data = data;
        this.webSocketSession = webSocketSession;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public Optional<String> getUserId() {
        return Optional.of(userId);
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public WebSocketSession getWebSocketSession() {
        return webSocketSession;
    }
}
