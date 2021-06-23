package com.talker.websocketlibrary.messaging;

import org.springframework.messaging.Message;

public class MessageToSend {
    public String name;
    public Object data;

    public MessageToSend(String name, Object data) {
        this.name = name;
        this.data = data;
    }

    public MessageToSend(String name) {
        this.name = name;
    }
}
