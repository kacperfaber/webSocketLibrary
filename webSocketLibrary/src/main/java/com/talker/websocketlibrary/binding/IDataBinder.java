package com.talker.websocketlibrary.binding;

public interface IDataBinder {
    <T> BindingResult<T> bind(String text, Class<T> dataClass);
}
