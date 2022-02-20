package com.talker.websocketlibrary.reflections;

import java.lang.reflect.Method;

public interface IMethodReturnTypeProvider {
    Class<?> provide(Method method);
}
