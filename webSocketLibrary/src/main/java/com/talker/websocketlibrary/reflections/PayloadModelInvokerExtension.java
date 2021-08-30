package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.annotations.ActionInvokerExtension;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ActionInvokerExtension(weight = 1000)
public class PayloadModelInvokerExtension implements IActionInvokerExtension{
    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) throws Exception {
        List<InvokeParameter> payloadParameters = actionInvoke.getParameters().stream()
                .filter(x -> x.parameterKind == ParameterKind.Payload)
                .collect(Collectors.toList());

        for (InvokeParameter param : payloadParameters) {
            // iterate through PayloadModelExtensions
        }
    }
}
