package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketMessage;

public interface IMessageReader {
    MessagePrototype read(String text) throws Exception;
}
