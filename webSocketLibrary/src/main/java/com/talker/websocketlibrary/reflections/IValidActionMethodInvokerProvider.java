package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.exceptions.MethodInvokerNotFoundException;

public interface IValidActionMethodInvokerProvider {
    IActionMethodInvoker provide(Class<?> returnType) throws MethodInvokerNotFoundException;
}
