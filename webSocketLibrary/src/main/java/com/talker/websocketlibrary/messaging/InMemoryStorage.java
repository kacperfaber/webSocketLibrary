package com.talker.websocketlibrary.messaging;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    List<MessageToSend> messageToSendList;

    public InMemoryStorage() {
        this.messageToSendList = new ArrayList<>();
    }

    public List<MessageToSend> getMessageToSendList() {
        return messageToSendList;
    }
}
