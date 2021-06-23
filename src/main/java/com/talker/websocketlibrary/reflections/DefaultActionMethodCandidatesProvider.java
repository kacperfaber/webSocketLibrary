package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Component
public class DefaultActionMethodCandidatesProvider implements IActionMethodCandidatesProvider {
    @Override
    public List<Method> provide(Class<? extends ControllerBase> controllerClass) {
        return Arrays
                .stream(controllerClass.getDeclaredMethods())
                .filter(i -> i.getDeclaredAnnotation(Action.class) != null)
                .toList();
    }
}
