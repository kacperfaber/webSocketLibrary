package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IExceptionHandler {
    void handle(Exception exception, ActionInvoke actionInvoke, HandlerEvent handlerEvent);
}
