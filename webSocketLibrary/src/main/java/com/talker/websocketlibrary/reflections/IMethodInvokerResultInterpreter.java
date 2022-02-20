package com.talker.websocketlibrary.reflections;

import java.util.Optional;

public interface IMethodInvokerResultInterpreter {
    void interpret(Optional<Object> methodInvokerResult);
}
