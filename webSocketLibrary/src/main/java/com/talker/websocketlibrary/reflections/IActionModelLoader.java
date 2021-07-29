package com.talker.websocketlibrary.reflections;

import java.lang.reflect.Method;

public interface IActionModelLoader {
    ActionModel load(Method method, Class<?> actionClass);
}
