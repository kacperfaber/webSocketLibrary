package com.talker.websocketlibrary.messaging;

public interface IMessageGenerator {
    Message generate(MessagePrototype messagePrototype, Object authenticatedUserId);
}
