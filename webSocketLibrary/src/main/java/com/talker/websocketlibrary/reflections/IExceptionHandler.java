package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Session;

public interface IExceptionHandler {
    void handle(Exception exception, ActionInvoke actionInvoke, HandlerEvent handlerEvent);
}
