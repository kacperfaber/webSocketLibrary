package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.lang.reflect.Method;
import java.util.List;

public interface IActionMethodCandidatesProvider {
    List<Method> provide(Class<? extends ControllerBase> controllerClass);
}
