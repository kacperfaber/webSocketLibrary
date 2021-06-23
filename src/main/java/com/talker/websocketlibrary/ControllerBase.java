package com.talker.websocketlibrary;

import com.talker.websocketlibrary.messaging.Session;

public abstract class ControllerBase {
    public <T> void send(String userId, String name, T data) {
        throw new UnsupportedOperationException();
    }

    public void send(Session session, String name) {
       throw new UnsupportedOperationException();
    }

    public void sendText(Session session, String name, String text) {
        throw new UnsupportedOperationException();
    }

    public <T> void broadcast(String name, T data) {
        throw new UnsupportedOperationException();
    }

    public void broadcastText(String name, String text) {
        throw new UnsupportedOperationException();
    }

    public <T> void broadcastToEveryone(String name, T data) {
        throw new UnsupportedOperationException();
    }

    public void kick(String userId) {
        throw new UnsupportedOperationException();
    }
}
