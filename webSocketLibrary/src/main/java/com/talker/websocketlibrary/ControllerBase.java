package com.talker.websocketlibrary;

import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.messaging.SessionService;
import com.talker.websocketlibrary.messaging.UserSession;
import com.talker.websocketlibrary.reflections.BroadcastResult;
import com.talker.websocketlibrary.reflections.Command;
import com.talker.websocketlibrary.reflections.ResponseResult;
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
        messageService.broadcast(name, data, dataClass);
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

    public <T> ResponseResult responseResult(String name, T data, Class<T> dataClass) {
        return new ResponseResult(name, data, dataClass);
    }

    public ResponseResult emptyResponse(String name) {
        return new ResponseResult(name, new Object(), Object.class);
    }

    public <T> BroadcastResult broadcastResult(String name, T data, Class<T> dataClass) {
        return new BroadcastResult(name, data, dataClass);
    }
}
