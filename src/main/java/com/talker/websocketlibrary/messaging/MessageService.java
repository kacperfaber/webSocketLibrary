package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Optional;

@Component
public class MessageService {
    public SessionService sessionService;
    public IMessageWriter messageWriter;

    public MessageService(SessionService sessionService, IMessageWriter messageWriter) {
        this.sessionService = sessionService;
        this.messageWriter = messageWriter;
    }

    public <T> boolean sendToSession(String sessionId, String name, T data, Class<T> dataClass) throws IOException {
        Optional<WebSocketSession> session = sessionService.getSessionById(sessionId);
        if (session.isPresent()) {
            SendMessage message = new SendMessage(name, data, dataClass);
            String messageText = messageWriter.writeMessage(message);
            TextMessage textMessage = new TextMessage(messageText);
            session.get().sendMessage(textMessage);
            return true;
        }
        return false;
    }

    public <T> boolean sendToUser(String userId, String name, T data, Class<T> dataClass) throws IOException {
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()) {
            SendMessage message = new SendMessage(name, data, dataClass);
            TextMessage textMessage = new TextMessage(messageWriter.writeMessage(message));
            session.sendMessage(textMessage);
            return true;
        }
        return false;
    }

    public <T> boolean sendToSession(WebSocketSession session, String name, T data, Class<T> dataClass) {
        try {
            SendMessage message = new SendMessage(name, data, dataClass);
            TextMessage textMessage = new TextMessage(messageWriter.writeMessage(message));
            session.sendMessage(textMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <T> boolean sendToSession(WebSocketSession session, SendMessage sendMessage) {
        try {
            TextMessage textMessage = new TextMessage(messageWriter.writeMessage(sendMessage));
            session.sendMessage(textMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
