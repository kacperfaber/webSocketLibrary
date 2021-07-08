package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;

@Component
public class DefaultMessageGenerator implements IMessageGenerator{
    @Override
    public Message generate(MessagePrototype messagePrototype, String authenticatedUserId) {
        return new Message(messagePrototype.getName(), messagePrototype.getData(), messagePrototype.getRawText(), authenticatedUserId);
    }
}
