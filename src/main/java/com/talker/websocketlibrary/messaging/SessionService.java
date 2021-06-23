package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.http.WebSocket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class SessionService {
    final List<UserSession> sessions = new ArrayList<>();

    public void disconnect(WebSocketSession session) throws IOException {
        session.close();
    }

    public void sendRawMessage(WebSocketSession session, String rawText) throws IOException {
        session.sendMessage(new TextMessage(rawText));
    }

    public UserSession getUserSession(String userId) {
        return sessions.stream().filter(x -> x.userId.equals(userId)).findFirst().orElse(null);
    }

    public void addSession(String userId, WebSocketSession webSocketSession) {
        UserSession userSession = getUserSession(userId);
        if (userSession == null) {
            UserSession newUserSession = new UserSession(userId);
            newUserSession.addSession(webSocketSession);
            sessions.add(newUserSession);
        }
        else {
            userSession.addSession(webSocketSession);
        }
    }
}
