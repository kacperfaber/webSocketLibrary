package com.talker.websocketlibrary.messaging;

public interface IMessageParser {
    Message read(String text, String userId);

    <T> MessageWithData<T> read(String text, String userId, Class<T> dataClass);
}
