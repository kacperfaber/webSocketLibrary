package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.commons.IDataWriter;

public class DefaultMessageWriter implements IMessageWriter{
    public IDataWriter dataWriter;
    @Override
    public String writeMessage(MessageToSend messageToSend) {
        String data = dataWriter.writeData(messageToSend.data);
        return messageToSend.name + " " + data;
    }
}
