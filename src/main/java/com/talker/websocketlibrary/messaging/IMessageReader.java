package com.talker.websocketlibrary.messaging;

import org.springframework.web.socket.WebSocketMessage;

public interface IMessageReader {
    Message read(String text, String userId);
}
