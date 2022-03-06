package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

@Component
public class DefaultActionMethodInvoker implements IActionMethodInvoker {
    @Override
    public Optional<Object> invoke(Method method, Object controller, Object[] params) throws InvocationTargetException, IllegalAccessException {
        try {
            Object res = method.invoke(controller, params);
            return Optional.ofNullable(res);
        }
        catch (Exception e) {
            return Optional.of(e);
        }
    }
}
