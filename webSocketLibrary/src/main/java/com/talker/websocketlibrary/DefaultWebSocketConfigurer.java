package com.talker.websocketlibrary;

import com.talker.websocketlibrary.handlers.BaseMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@ComponentScan({"com.talker.websocketlibrary.handlers"})
public class DefaultWebSocketConfigurer implements WebSocketConfigurer {

    @Autowired
    public BaseMessageHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/server");
    }
}
