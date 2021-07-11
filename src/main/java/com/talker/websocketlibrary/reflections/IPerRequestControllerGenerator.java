package com.talker.websocketlibrary.reflections;

import org.springframework.web.socket.WebSocketSession;

public interface IPerRequestControllerGenerator {
    PerRequestController generate(WebSocketSession webSocketSession);
}
