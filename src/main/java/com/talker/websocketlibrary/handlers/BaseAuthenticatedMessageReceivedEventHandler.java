package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.messaging.IMessageReader;
import com.talker.websocketlibrary.messaging.Message;
import com.talker.websocketlibrary.reflections.IActionCommandsInvoker;
import com.talker.websocketlibrary.reflections.Model;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

import java.util.Optional;

@Component
public class BaseAuthenticatedMessageReceivedEventHandler implements IEventHandler {
    Model model;
    IActionCommandsInvoker actionCommandsInvoker;
    IMessageReader reader;

    public BaseAuthenticatedMessageReceivedEventHandler(Model model, IActionCommandsInvoker actionCommandsInvoker, IMessageReader reader) {
        this.model = model;
        this.actionCommandsInvoker = actionCommandsInvoker;
        this.reader = reader;
    }

    @Override
    public boolean canHandle(HandlerEvent handlerEvent) {
        return handlerEvent.getKind() == HandlerEventKind.MessageReceived &&
                handlerEvent.getMessage().isPresent() &&
                handlerEvent.isAuthenticated();
    }

    @Override
    public void handle(HandlerEvent handlerEvent) {
        Optional<WebSocketMessage> optionalMessage = handlerEvent.getMessage();
        if (optionalMessage.isPresent()) {
            WebSocketMessage webSocketMessage = optionalMessage.get();
            Message message = reader.read(webSocketMessage.toString(), handlerEvent.authenticatedUserId);
            actionCommandsInvoker.invokeAll(model, message);
        }
    }
}
