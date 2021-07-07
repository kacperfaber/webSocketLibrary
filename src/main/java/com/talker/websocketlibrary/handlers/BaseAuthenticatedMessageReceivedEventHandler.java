package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.reflections.IActionCommandsInvoker;
import com.talker.websocketlibrary.reflections.Model;
import org.springframework.stereotype.Component;

@Component
public class BaseAuthenticatedMessageReceivedEventHandler implements IEventHandler {
    Model model;
    IActionCommandsInvoker actionCommandsInvoker;

    @Override
    public boolean canHandle(HandlerEvent handlerEvent) {
        return handlerEvent.getKind() == HandlerEventKind.MessageReceived &&
                handlerEvent.getMessage().isPresent() &&
                handlerEvent.isAuthenticated();
    }

    @Override
    public void handle(HandlerEvent handlerEvent) {
        actionCommandsInvoker.invokeAll(model, handlerEvent.getMessage().toString());
    }
}
