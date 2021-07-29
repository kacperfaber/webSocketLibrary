package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class DefaultCommandGenerator implements ICommandGenerator {
    @Override
    public Command generate(Message message, HandlerEvent handlerEvent) {
        return new Command(message.getName(), message.getRawText(), message.getDataText(), message.getUserId(), handlerEvent.getSession().getId());
    }
}
