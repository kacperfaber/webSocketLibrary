package com.talker.websocketlibrary;

public class ResponseMessage {
    Class<?> dataClass;
    Object data;

    public <T> ResponseMessage(T data, Class<T> dataClass) {
        this.data = data;
        this.dataClass = dataClass;
    }

    public <T> void setData(T data, Class<T> dataClass) {
        this.data = data;
        this.dataClass = dataClass;
    }

    public Class<?> getDataClass() {
        return dataClass;
    }

    public Object getData() {
        return data;
    }
}
