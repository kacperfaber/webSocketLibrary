package com.talker.websocketlibrary.commons;

public interface IDataWriter {
    String writeData(Object data);

    <T> String writeData(T data, Class<T> dataClass);
}
