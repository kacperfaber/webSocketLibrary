package com.talker.websocketlibrary.handlers;

import com.talker.websocketlibrary.messaging.*;
import com.talker.websocketlibrary.reflections.IActionCommandInvoker;
import com.talker.websocketlibrary.reflections.Model;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Component
public class BaseMessageReceivedEventHandler implements IEventHandler {
    IActionCommandInvoker actionCommandsInvoker;
    IMessageReader reader;
    IMessageGenerator messageGenerator;
    IMessageTextValidator messageTextValidator;
    ApplicationContext applicationContext;

    public BaseMessageReceivedEventHandler(ApplicationContext applicationContext, IActionCommandInvoker actionCommandsInvoker, IMessageReader reader, IMessageGenerator messageGenerator, IMessageTextValidator messageTextValidator) {
        this.actionCommandsInvoker = actionCommandsInvoker;
        this.reader = reader;
        this.messageGenerator = messageGenerator;
        this.messageTextValidator = messageTextValidator;
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean canHandle(HandlerEvent handlerEvent) {
        return handlerEvent.getKind() == HandlerEventKind.MessageReceived && handlerEvent.getMessage().isPresent();
    }

    @Override
    public void handle(HandlerEvent handlerEvent) throws Exception {
        Optional<WebSocketMessage> optionalMessage = handlerEvent.getMessage();
        if (optionalMessage.isPresent()) {
            WebSocketMessage webSocketMessage = optionalMessage.get();
            if (messageTextValidator.validate(webSocketMessage.getPayload().toString())) {
                MessagePrototype messageProto = reader.readMessage(webSocketMessage.getPayload().toString());
                Message message = messageGenerator.generate(messageProto, handlerEvent.getAuthenticatedUserId().orElse(null));
                try {
                    actionCommandsInvoker.invoke(applicationContext.getBean(Model.class), message, handlerEvent);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
