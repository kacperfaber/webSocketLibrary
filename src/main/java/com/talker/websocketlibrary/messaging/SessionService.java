package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SessionService {
    final List<UserSession> sessions = new ArrayList<>();

    public void disconnect(WebSocketSession session) throws IOException {
        session.close();
    }

    public boolean closeSession(String sessionId) throws IOException {
        Optional<WebSocketSession> optionalSession = getSessionById(sessionId);
        if (optionalSession.isPresent()){
            optionalSession.get().close();
            return true;
        }
        return false;
    }

    public boolean closeSession(String sessionId, CloseStatus closeStatus) throws IOException {
        Optional<WebSocketSession> optionalSession = getSessionById(sessionId);
        if (optionalSession.isPresent()){
            optionalSession.get().close(closeStatus);
            return true;
        }
        return false;
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

    public Optional<UserSession> getUserSession(String userId) {
        return sessions.stream().filter(x -> x.userId.equals(userId)).findFirst();
    }

    public void addSession(String userId, WebSocketSession webSocketSession) {
        Optional<UserSession> userSession = getUserSession(userId);
        if (userSession.isEmpty()) {
            UserSession newUserSession = new UserSession(userId);
            newUserSession.addSession(webSocketSession);
            sessions.add(newUserSession);
        }
        else {
            userSession.get().addSession(webSocketSession);
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
                    return Optional.ofNullable(userSession.userId);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<WebSocketSession> getSessionById(String sessionId) {
        for(WebSocketSession session : getAllSessions()) {
            if (session.getId().equalsIgnoreCase(sessionId)) return Optional.of(session);
        }
        return Optional.empty();
    }

    public UserSession getUserSessionBy(String id) throws Exception {
        for (UserSession userSession : sessions) {
            for (WebSocketSession session : userSession.getSessions()) {
                if (session.getId().equals(id)) {
                    return userSession;
                }
            }
        }
        throw new Exception();
    }
}
