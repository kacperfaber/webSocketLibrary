package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.messaging.SendMessage;
import com.talker.websocketlibrary.messaging.SessionService;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;

public class PerRequestController {
    MessageService messageService;
    SessionService sessionService;
    WebSocketSession currentSession;

    public PerRequestController(MessageService messageService, SessionService sessionService, WebSocketSession currentSession) {
        this.messageService = messageService;
        this.sessionService = sessionService;
        this.currentSession = currentSession;
    }

    public <T> void sendMessage(String name, T data, Class<T> dataClass) {
        messageService.sendToSession(currentSession, name, data, dataClass);
    }

    public <T> void sendMessage(SendMessage<T> sendMessage) {
        messageService.sendToSession(currentSession, sendMessage);
    }

    public void kick(CloseStatus closeStatus) {
        sessionService.closeSession(currentSession, closeStatus);
    }

    public void kick() {
        sessionService.closeSession(currentSession);
    }
}
