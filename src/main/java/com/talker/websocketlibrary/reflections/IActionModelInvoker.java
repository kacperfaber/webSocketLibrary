package com.talker.websocketlibrary.reflections;

import java.lang.reflect.InvocationTargetException;

public interface IActionModelInvoker {
    void invoke(ActionModel actionModel, Object controller, Command command) throws InvocationTargetException, IllegalAccessException;
}
