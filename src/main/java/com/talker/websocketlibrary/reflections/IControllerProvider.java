package com.talker.websocketlibrary.reflections;

public interface IControllerProvider {
    Object provide(Class<?> controllerClass);
}
