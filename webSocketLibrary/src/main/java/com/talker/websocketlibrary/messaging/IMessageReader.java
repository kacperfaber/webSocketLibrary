package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketMessage;

public interface IMessageReader {
    MessagePrototype readMessage(String text) throws Exception;
}
