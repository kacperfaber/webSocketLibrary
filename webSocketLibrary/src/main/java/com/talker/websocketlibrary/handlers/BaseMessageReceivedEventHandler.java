package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.messaging.*;
import com.talker.websocketlibrary.reflections.IActionCommandInvoker;
import com.talker.websocketlibrary.reflections.Model;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Component
public class BaseMessageReceivedEventHandler implements IEventHandler {
    Model model;
    IActionCommandInvoker actionCommandsInvoker;
    IMessageReader reader;
    IMessageGenerator messageGenerator;
    IMessageTextValidator messageTextValidator;

    public BaseMessageReceivedEventHandler(Model model, IActionCommandInvoker actionCommandsInvoker, IMessageReader reader, IMessageGenerator messageGenerator, IMessageTextValidator messageTextValidator) {
        this.model = model;
        this.actionCommandsInvoker = actionCommandsInvoker;
        this.reader = reader;
        this.messageGenerator = messageGenerator;
        this.messageTextValidator = messageTextValidator;
    }

    @Override
    public boolean canHandle(HandlerEvent handlerEvent) {
        return handlerEvent.getKind() == HandlerEventKind.MessageReceived &&
                handlerEvent.getMessage().isPresent();
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
                    actionCommandsInvoker.invoke(model, message, handlerEvent);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
