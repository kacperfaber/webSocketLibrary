package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Message;

import java.lang.reflect.InvocationTargetException;

public interface IActionCommandsInvoker {
    void invokeAll(Model model, Message message, HandlerEvent handlerEvent) throws InvocationTargetException, IllegalAccessException;
}
