package com.talker.websocketlibrary.binding;

public class BindingResult<T> {
    public T data;
    public Class<T> dataClass;

    public BindingResult(T data, Class<T> dataClass) {
        this.data = data;
        this.dataClass = dataClass;
    }
}
