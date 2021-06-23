package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public class MessageService {
    public SessionService sessionService;
    public IMessageWriter messageWriter;

    public <T> void sendMessage(String userId, String name, T data) throws IOException {
        MessageToSend messageToSend = new MessageToSend(name, data);
        String messageText = messageWriter.writeMessage(messageToSend);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            sessionService.sendRawMessage(session, messageText);
        }
    }

    public void sendMessage(String userId, String name) throws IOException {
        MessageToSend messageToSend = new MessageToSend(name);
        String messageText = messageWriter.writeMessage(messageToSend);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            sessionService.sendRawMessage(session, messageText);
        }
    }
}
