package com.talker.websocketlibrary.reflections;

import java.util.Optional;

public interface IResultInterpreter {
    boolean canInterpret(Optional<Object> methodInvokerResult);
    void interpret(Optional<Object> methodInvokerResult, Command command);
}
