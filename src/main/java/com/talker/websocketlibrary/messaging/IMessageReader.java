package com.talker.websocketlibrary.messaging;

public interface IMessageReader {
    Message read(String text, String userId);
}
