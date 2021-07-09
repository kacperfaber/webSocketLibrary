package com.talker.websocketlibrary;

import com.talker.websocketlibrary.reflections.AllowAnonymous;
import com.talker.websocketlibrary.reflections.Command;
import com.talker.websocketlibrary.reflections.annotations.SocketAction;
import com.talker.websocketlibrary.reflections.annotations.SocketController;
import org.springframework.stereotype.Component;

@SocketController
@Component
public class TestController {
    @SocketAction("asUser")
    public void asUser(Command command) {
        return;
    }
    @SocketAction("asAnonymous")
    @AllowAnonymous
    public void asAnonymous(Command command) {
        return;
    }
}
