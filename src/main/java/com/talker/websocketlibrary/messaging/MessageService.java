package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public class MessageService {
    public SessionService sessionService;
    public IMessageWriter messageWriter;

    public <T> boolean sendMessage(String userId, String name, T data) {
        SendMessage sendMessage = new SendMessage(name, data);
        String messageText = messageWriter.writeMessage(sendMessage);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            if (!sessionService.sendRawMessage(session, messageText)){
                return false;
            }
        }
        return true;
    }

    public boolean sendMessage(String userId, String name) {
        SendMessage sendMessage = new SendMessage(name);
        String messageText = messageWriter.writeMessage(sendMessage);
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession session : userSession.getSessions()){
            if (!sessionService.sendRawMessage(session, messageText)) {
                return false;
            }
        }
        return true;
    }
}
