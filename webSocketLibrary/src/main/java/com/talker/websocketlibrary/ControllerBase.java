package com.talker.websocketlibrary;

import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.messaging.SendMessage;
import com.talker.websocketlibrary.messaging.SessionService;
import com.talker.websocketlibrary.messaging.UserSession;
import com.talker.websocketlibrary.reflections.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public abstract class ControllerBase {
    @Autowired
    public MessageService messageService;
    @Autowired
    public SessionService sessionService;
    @Autowired
    IDataBinder dataBinder;

    public <T> void sendToUser(String userId, String name, T data, Class<T> dataClass) throws IOException {
        messageService.sendToUser(userId, name, data, dataClass);
    }

    public void sendToUser(String userId, String name) throws IOException {
        messageService.sendToUser(userId, name, new Object(), Object.class);
    }

    public <T> void sendToWebSocketSession(String sessionId, String name, T data, Class<T> dataClass) throws IOException {
        messageService.sendToSession(sessionId, name, data, dataClass);
    }

    public <T> void broadcast(String name, T data, Class<T> dataClass) throws IOException {
        SendMessage<T> sendMessage = new SendMessage<>(name, data, dataClass);
        for (WebSocketSession session : sessionService.getAllSessions()) {
            messageService.sendToSession(session.getId(), name, data, dataClass);
        }
    }

    public int kick(String userId) throws IOException {
        int totalKicked = 0;
        UserSession userSession = sessionService.getUserSession(userId);
        for (WebSocketSession webSocketSession : userSession.getSessions()) {
            webSocketSession.close();
            totalKicked++;
        }
        return totalKicked;
    }

    public <T> T bind(Command command, Class<T> tClass) {
        return dataBinder.bind(command.getDataText(), tClass).data;
    }
}
