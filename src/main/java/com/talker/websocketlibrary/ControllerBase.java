package com.talker.websocketlibrary;

import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.messaging.SessionService;
import com.talker.websocketlibrary.messaging.UserSession;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public abstract class ControllerBase {
    public MessageService messageService;
    public SessionService sessionService;

    public <T> void send(String userId, String name, T data, Class<T> dataClass) throws IOException {
        messageService.sendMessage(userId, name, data);
    }

    public void send(String userId, String name) throws IOException {
        messageService.sendMessage(userId, name);
    }

    public <T> void sendToWebSocketSession(String sessionId, String name, T data, Class<T> dataClass) {
        throw new UnsupportedOperationException();
    }

    public void sendToWebSocketSession(String sessionId, String name, String text) {
        throw new UnsupportedOperationException();
    }

    public <T> void broadcast(String name, T data, Class<T> dataClass, BroadcastTarget broadcastTarget) {
        throw new UnsupportedOperationException();
    }

    public void broadcastText(String name, String text, BroadcastTarget broadcastTarget) {
        throw new UnsupportedOperationException();
    }

    public void disconnectUser(String userId) throws IOException {
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession sess : userSession.getSessions()) {
            sess.close();
        }
    }
}
