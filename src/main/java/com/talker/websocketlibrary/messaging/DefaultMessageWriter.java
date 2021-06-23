package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.commons.IDataWriter;
import org.springframework.stereotype.Component;

@Component
public class DefaultMessageWriter implements IMessageWriter{
    public IDataWriter dataWriter;

    public DefaultMessageWriter(IDataWriter dataWriter) {
        this.dataWriter = dataWriter;
    }

    @Override
    public String writeMessage(MessageToSend messageToSend) {
        String data = dataWriter.writeData(messageToSend.data);
        return messageToSend.name + " " + data;
    }
}
