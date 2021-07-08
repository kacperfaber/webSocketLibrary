package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.messaging.*;
import com.talker.websocketlibrary.reflections.IActionCommandsInvoker;
import com.talker.websocketlibrary.reflections.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Component
public class BaseAuthenticatedMessageReceivedEventHandler implements IEventHandler {
    Model model;
    IActionCommandsInvoker actionCommandsInvoker;
    IMessageReader reader;
    IMessageGenerator messageGenerator;
    IMessageTextValidator messageTextValidator;

    public BaseAuthenticatedMessageReceivedEventHandler(Model model, IActionCommandsInvoker actionCommandsInvoker, IMessageReader reader, IMessageGenerator messageGenerator, IMessageTextValidator messageTextValidator) {
        this.model = model;
        this.actionCommandsInvoker = actionCommandsInvoker;
        this.reader = reader;
        this.messageGenerator = messageGenerator;
        this.messageTextValidator = messageTextValidator;
    }

    @Override
    public boolean canHandle(HandlerEvent handlerEvent) {
        return handlerEvent.getKind() == HandlerEventKind.MessageReceived &&
                handlerEvent.getMessage().isPresent() &&
                handlerEvent.isAuthenticated();
    }

    @Override
    public void handle(HandlerEvent handlerEvent) throws Exception{
        Optional<WebSocketMessage> optionalMessage = handlerEvent.getMessage();
        if (optionalMessage.isPresent()) {
            WebSocketMessage webSocketMessage = optionalMessage.get();
            if (messageTextValidator.validate(webSocketMessage.getPayload().toString())) {
                MessagePrototype messageProto = reader.read(webSocketMessage.getPayload().toString());
                Message message = messageGenerator.generate(messageProto, handlerEvent.getAuthenticatedUserId().orElse(null));
                try {
                    actionCommandsInvoker.invokeAll(model, message, handlerEvent);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
