package com.talker.websocketlibrary;

public abstract class ControllerBase {
    public <T> void send(String userId, String name, T data) {
        throw new UnsupportedOperationException();
    }

    public void send(String userId, String name) {
       throw new UnsupportedOperationException();
    }

    public void sendText(String userId, String name, String text) {
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
