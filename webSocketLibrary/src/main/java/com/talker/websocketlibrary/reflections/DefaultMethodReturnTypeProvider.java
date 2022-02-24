package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DefaultMethodReturnTypeProvider implements IMethodReturnTypeProvider {
    @Override
    public Class<?> provide(Method method) {
        return method.getReturnType();
    }
}
