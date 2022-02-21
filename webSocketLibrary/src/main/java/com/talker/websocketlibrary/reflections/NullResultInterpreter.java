package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NullResultInterpreter implements IResultInterpreter{
    @Override
    public boolean canInterpret(Optional<Object> methodInvokerResult) {
        return methodInvokerResult.isEmpty();
    }

    @Override
    public void interpret(Optional<Object> methodInvokerResult, Command command) {

    }
}
