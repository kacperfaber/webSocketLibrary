package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
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
        Optional<UserSession> userSessionOptional = sessionService.getUserSession(userId);
        if (userSessionOptional.isPresent()) {
            for (WebSocketSession session : userSessionOptional.get().getSessions()) {
                SendMessage message = new SendMessage(name, data, dataClass);
                TextMessage textMessage = new TextMessage(messageWriter.writeMessage(message));
                session.sendMessage(textMessage);
                return true;
            }
        }
        return false;
    }
}
