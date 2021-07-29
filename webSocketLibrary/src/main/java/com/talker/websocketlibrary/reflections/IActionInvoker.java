package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

import java.lang.reflect.InvocationTargetException;

public interface IActionInvoker {
    void invoke(ActionModel actionModel, Object controller, Command command, HandlerEvent handlerEvent) throws InvocationTargetException, IllegalAccessException;
}
