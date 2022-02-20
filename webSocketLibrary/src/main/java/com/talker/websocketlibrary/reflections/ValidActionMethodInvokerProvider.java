package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.MethodInvoker;
import com.talker.websocketlibrary.reflections.exceptions.MethodInvokerNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidActionMethodInvokerProvider implements IValidActionMethodInvokerProvider{
    public List<IActionMethodInvoker> invokers;

    public ValidActionMethodInvokerProvider(List<IActionMethodInvoker> invokers) {
        this.invokers = invokers;
    }

    @Override
    public IActionMethodInvoker provide(Class<?> returnType) throws MethodInvokerNotFoundException {
        // TODO: simplify it.
        List<IActionMethodInvoker> list = invokers.stream().filter(x -> Arrays.asList(x.getClass().getAnnotation(MethodInvoker.class).validOn()).contains(returnType)).collect(Collectors.toList());
        return list.stream().findFirst().orElseThrow(MethodInvokerNotFoundException::new);
    }
}
