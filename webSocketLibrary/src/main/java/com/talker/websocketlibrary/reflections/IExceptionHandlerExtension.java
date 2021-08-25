package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Session;

public interface IExceptionHandlerExtension {
    void handle(HandlerEvent handlerEvent, Session session, Exception exception);
}
