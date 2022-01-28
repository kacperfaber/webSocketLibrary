package com.talker.websocketlibrary;

import org.springframework.web.socket.WebSocketHandler;

abstract public class SocketHandler implements WebSocketHandler {
    abstract public RegistrationOptions getOptions();
}
