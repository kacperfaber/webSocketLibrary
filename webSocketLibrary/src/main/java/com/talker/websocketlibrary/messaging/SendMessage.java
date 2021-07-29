package com.talker.websocketlibrary.messaging;

import org.springframework.messaging.Message;

public class SendMessage<T> {
    public String name;
    public T data;
    final Class<T> dataClass;

    public SendMessage(String name, T data, Class<T> dataClass) {
        this.name = name;
        this.data = data;
        this.dataClass = dataClass;
    }
}
