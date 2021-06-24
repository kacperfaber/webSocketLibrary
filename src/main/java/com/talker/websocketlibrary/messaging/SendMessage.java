package com.talker.websocketlibrary.messaging;

import org.springframework.messaging.Message;

public class SendMessage {
    public String name;
    public Object data;

    public SendMessage(String name, Object data) {
        this.name = name;
        this.data = data;
    }

    public SendMessage(String name) {
        this.name = name;
    }
}
