package com.talker.websocketlibrary;

import com.talker.websocketlibrary.messaging.SessionService;
import com.talker.websocketlibrary.messaging.UserSession;

import java.io.IOException;

public abstract class ControllerBase {
    public SessionService sessionService;

    public <T> void send(String userId, String name, T data, Class<T> dataClass) {
        throw new UnsupportedOperationException();
    }

    public void send(String userId, String name) {
        throw new UnsupportedOperationException();
    }

    public void sendText(String userId, String text) throws IOException {
        UserSession userSession = sessionService.getUserSession(userId);
        sessionService.sendRawMessage(userSession, text);
    }

    public <T> void sendToWebSocketSession(String sessionId, String name, T data, Class<T> dataClass) {
        throw new UnsupportedOperationException();
    }

    public void sendToWebSocketSession(String sessionId, String name, String text) {
        throw new UnsupportedOperationException();
    }

    public <T> void broadcast(String name, T data, Class<T> dataClass) {
        throw new UnsupportedOperationException();
    }

    public void broadcastText(String name, String text) {
        throw new UnsupportedOperationException();
    }

    public <T> void broadcastToEveryone(String name, T data, Class<T> dataClass) {
        throw new UnsupportedOperationException();
    }

    public void kick(String userId) {
        throw new UnsupportedOperationException();
    }
}
