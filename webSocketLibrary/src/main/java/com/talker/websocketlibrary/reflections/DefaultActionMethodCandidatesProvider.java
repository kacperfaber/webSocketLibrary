package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.SocketAction;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultActionMethodCandidatesProvider implements IActionMethodCandidatesProvider {
    @Override
    public List<Method> provide(Class<?> actionClass) {
        return Arrays.stream(actionClass.getDeclaredMethods()).filter(i -> i.getDeclaredAnnotation(SocketAction.class) != null).collect(Collectors.toList());
    }
}
