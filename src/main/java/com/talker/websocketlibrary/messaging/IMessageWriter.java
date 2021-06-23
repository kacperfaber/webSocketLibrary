package com.talker.websocketlibrary.messaging;

public interface IMessageWriter {
    String writeMessage(MessageToSend messageToSend);
}
