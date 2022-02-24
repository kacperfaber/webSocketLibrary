package com.talker.websocketlibrary.messaging;

public interface IMessageReader {
    MessagePrototype readMessage(String text) throws Exception;
}
