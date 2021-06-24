package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public class MessageService {
    public SessionService sessionService;
    public IMessageWriter messageWriter;

    public <T> void sendMessage(String userId, String name, T data) throws IOException {
        SendMessage sendMessage = new SendMessage(name, data);
        String messageText = messageWriter.writeMessage(sendMessage);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            sessionService.sendRawMessage(session, messageText);
        }
    }

    public void sendMessage(String userId, String name) throws IOException {
        SendMessage sendMessage = new SendMessage(name);
        String messageText = messageWriter.writeMessage(sendMessage);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            sessionService.sendRawMessage(session, messageText);
        }
    }
}
