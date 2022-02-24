package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SessionService {
    final List<Session> sessions = new ArrayList<>();

    public void disconnect(WebSocketSession session) throws IOException {
        session.close();
    }

    public boolean closeSession(String sessionId) throws IOException {
        Optional<WebSocketSession> optionalSession = getSessionById(sessionId);
        if (optionalSession.isPresent()) {
            optionalSession.get().close();
            return true;
        }
        return false;
    }

    public boolean closeSession(WebSocketSession webSocketSession) {
        try {
            webSocketSession.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean closeSession(WebSocketSession session, CloseStatus closeStatus) {
        try {
            session.close(closeStatus);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean closeSession(String sessionId, CloseStatus closeStatus) throws IOException {
        Optional<WebSocketSession> optionalSession = getSessionById(sessionId);
        if (optionalSession.isPresent()) {
            optionalSession.get().close(closeStatus);
            return true;
        }
        return false;
    }

    public boolean sendRawMessage(WebSocketSession session, String rawText) {
        try {
            session.sendMessage(new TextMessage(rawText));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public UserSession getUserSession(String userId) {
        List<WebSocketSession> userSessions = sessions.stream().filter(x -> x.userId.equals(userId)).map(Session::getSession).collect(Collectors.toList());
        return new UserSession(userId, userSessions);
    }

    public void addSession(WebSocketSession webSocketSession) {
        sessions.add(new Session(webSocketSession.getId(), webSocketSession));
    }

    public List<WebSocketSession> getAllSessions() {
        return sessions.stream().map(Session::getSession).collect(Collectors.toList());
    }

    public Optional<Object> getUserId(WebSocketSession session) {
        Optional<Session> optionalSession = sessions.stream().filter(x -> x.sessionId.equals(session.getId())).findFirst();
        return optionalSession.map(Session::getUserId);
    }

    public Optional<WebSocketSession> getSessionById(String sessionId) {
        for (Session session : sessions) {
            if (session.getSessionId().equals(sessionId)) {
                return Optional.of(session.getSession());
            }
        }
        return Optional.empty();
    }

    public Optional<Session> getSession(String sessionId) {
        return sessions.stream().filter(x -> x.getSessionId().equals(sessionId)).findFirst();
    }
}
