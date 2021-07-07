package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.http.WebSocket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SessionService {
    final List<UserSession> sessions = new ArrayList<>();

    public void disconnect(WebSocketSession session) throws IOException {
        session.close();
    }

    public boolean sendRawMessage(WebSocketSession session, String rawText) {
        try {
            session.sendMessage(new TextMessage(rawText));
            return true;
        }

        catch (IOException e) {
            return false;
        }
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

    public List<WebSocketSession> getAllSessions() {
        ArrayList<WebSocketSession> allSessions = new ArrayList<>();
        for (UserSession userSession : sessions) {
            allSessions.addAll(userSession.getSessions());
        }
        return allSessions;
    }

    public Optional<String> getUserId(WebSocketSession session) {
        for (UserSession userSession : sessions) {
            for (WebSocketSession webSocketSession : userSession.getSessions()) {
                if (webSocketSession.getId().equalsIgnoreCase(session.getId())) {
                    return Optional.of(userSession.userId);
                }
            }
        }
        return Optional.empty();
    }
}
