package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MethodInvokerResultInterpreter implements IMethodInvokerResultInterpreter{
    public final List<IResultInterpreter> interpreterList;

    public MethodInvokerResultInterpreter(List<IResultInterpreter> interpreterList) {
        this.interpreterList = interpreterList;
    }

    @Override
    public void interpret(Optional<Object> methodInvokerResult) {
        interpreterList.stream().filter(x -> x.canInterpret(methodInvokerResult)).forEach(x -> x.interpret(methodInvokerResult));
    }
}
