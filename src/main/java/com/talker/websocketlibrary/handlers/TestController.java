package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.ControllerBase;
import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.reflections.Command;
import com.talker.websocketlibrary.reflections.annotations.SocketAction;
import com.talker.websocketlibrary.reflections.annotations.SocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@SocketController
public class TestController extends ControllerBase {
    @SocketAction("test")
    public void testMethod(Command command) {

    }

    @SocketAction("disconnect")
    public void disconnect(Command command) {
        this.sendToWebSocketSession(command.getSessionId(), "disconnected", "");
    }
}
