package com.talker.websocketlibrary.reflections;

import java.lang.reflect.InvocationTargetException;

public interface IActionInvoker {
    void invoke(ActionModel actionModel, Object controller, Command command) throws InvocationTargetException, IllegalAccessException;
}
