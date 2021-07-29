package com.talker.websocketlibrary.binding;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class JsonDataBinder implements IDataBinder {
    final Gson gson = new Gson();

    @Override
    public <T> BindingResult<T> bind(String text, Class<T> dataClass) {
        T data = gson.fromJson(text, dataClass);
        return new BindingResult<T>(data, dataClass);
    }
}
