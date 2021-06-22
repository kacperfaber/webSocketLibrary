package com.talker.websocketlibrary;

public class MessageWithData<T> extends Message{
    Class<T> dataClass;
    T data;

    public MessageWithData(String name, String dataText, T data, Class<T> dataClass) {
        super(name, dataText);
        this.data = data;
        this.dataClass = dataClass;
    }

    public MessageWithData(String name, String dataText, T data) {
        super(name, dataText);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Class<?> getDataClass() {
        return dataClass;
    }
}
