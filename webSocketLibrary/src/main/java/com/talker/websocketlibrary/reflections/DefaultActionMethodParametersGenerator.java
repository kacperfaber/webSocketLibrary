package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DefaultActionMethodParametersGenerator implements IActionMethodParametersGenerator {
    @Override
    public Object[] generate(Method actionMethod, List<InvokeParameter> invokeParameters) {
        List<Object> parameters = new ArrayList<>(actionMethod.getParameterCount());
        List<InvokeParameter> orderedList = invokeParameters.stream().sorted(Comparator.comparingInt(o -> o.weigth)).collect(Collectors.toList());

        for (Class<?> parameterType : actionMethod.getParameterTypes()) {
            Optional<InvokeParameter> first = orderedList.stream().filter(y -> y.getParameterClass() == parameterType).findFirst();
            first.ifPresent(invokeParameter -> parameters.add(invokeParameter.parameter));
        }
        return parameters.toArray();
    }
}
