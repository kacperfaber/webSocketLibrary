package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Session;
import com.talker.websocketlibrary.messaging.SessionService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SessionInvokerExtension implements IActionInvokerExtension{
    SessionService sessionService;

    public SessionInvokerExtension(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) {
        Optional<Session> session = sessionService.getSession(actionInvoke.getCommand().getSessionId());
        actionInvoke.addParameter(session.orElse(null), Session.class, 0);
    }
}
