package com.talker.websocketlibrary.reflections;

import java.io.IOException;
import java.util.Optional;

public interface IResultInterpreter {
    boolean canInterpret(Optional<Object> methodInvokerResult);

    void interpret(Optional<Object> methodInvokerResult, Command command) throws IOException;
}
