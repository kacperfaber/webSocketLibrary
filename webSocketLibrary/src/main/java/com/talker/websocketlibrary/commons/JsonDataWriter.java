package com.talker.websocketlibrary.commons;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JsonDataWriter implements IDataWriter {
    final Gson gson = new Gson();

    @Override
    public String writeData(Object data) {
        return gson.toJson(data);
    }

    @Override
    public <T> String writeData(T data, Class<T> dataClass) {
        return gson.toJson(data, dataClass);
    }
}
