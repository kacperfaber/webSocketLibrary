package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IExceptionHandlerExtension {
    void handle(HandlerEvent handlerEvent, ActionInvoke actionInvoke, Exception exception);
}
