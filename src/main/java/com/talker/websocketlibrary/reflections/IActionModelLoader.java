package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.lang.reflect.Method;

public interface IActionModelLoader {
    ActionModel load(Method method, Class<?> actionClass);
}
