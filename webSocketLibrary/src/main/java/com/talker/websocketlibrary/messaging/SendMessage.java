package com.talker.websocketlibrary.messaging;

public class SendMessage<T> {
    final Class<T> dataClass;
    public String name;
    public T data;

    public SendMessage(String name, T data, Class<T> dataClass) {
        this.name = name;
        this.data = data;
        this.dataClass = dataClass;
    }
}
