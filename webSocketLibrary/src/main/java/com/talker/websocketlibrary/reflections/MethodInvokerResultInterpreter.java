package com.talker.websocketlibrary.reflections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MethodInvokerResultInterpreter implements IMethodInvokerResultInterpreter{
    @Autowired
    public List<IResultInterpreter> interpreterList;
    @Override
    public void interpret(Optional<Object> methodInvokerResult) {
        interpreterList.stream().filter(x -> x.canInterpret(methodInvokerResult)).forEach(x -> x.interpret(methodInvokerResult));
    }
}
