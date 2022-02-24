package com.talker.websocketlibrary.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public interface IActionMethodInvoker {
    Optional<Object> invoke(Method method, Object controller, Object[] params) throws InvocationTargetException, IllegalAccessException;
}
