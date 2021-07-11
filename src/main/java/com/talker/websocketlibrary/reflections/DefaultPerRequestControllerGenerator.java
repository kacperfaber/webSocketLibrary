package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.messaging.SessionService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class DefaultPerRequestControllerGenerator implements IPerRequestControllerGenerator {
    ApplicationContext appContext;
    SessionService sessionService;

    public DefaultPerRequestControllerGenerator(ApplicationContext appContext, SessionService sessionService) {
        this.appContext = appContext;
        this.sessionService = sessionService;
    }

    @Override
    public PerRequestController generate(WebSocketSession webSocketSession) {
        return new PerRequestController(appContext.getBean(MessageService.class), appContext.getBean(SessionService.class), webSocketSession);
    }
}
