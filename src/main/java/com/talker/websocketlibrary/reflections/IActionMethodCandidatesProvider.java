package com.talker.websocketlibrary.reflections;


import java.lang.reflect.Method;
import java.util.List;

public interface IActionMethodCandidatesProvider {
    List<Method> provide(Class<?> actionClass);
}
