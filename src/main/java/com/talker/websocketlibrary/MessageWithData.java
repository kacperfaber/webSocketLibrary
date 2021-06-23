package com.talker.websocketlibrary;

public class MessageWithData<T> extends Message{
    Class<T> dataClass;
    T data;

    public MessageWithData(String name, String dataText, String rawText, T data, Class<T> dataClass) {
        super(name, dataText, rawText);
        this.dataClass = dataClass;
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public Class<?> getDataClass() {
        return dataClass;
    }
}
