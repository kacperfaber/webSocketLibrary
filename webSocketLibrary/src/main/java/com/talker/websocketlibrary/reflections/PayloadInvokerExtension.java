package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Component
public class PayloadInvokerExtension implements IActionInvokerExtension {
    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) {
        Parameter[] params = actionInvoke.getActionModel().method.getParameters();
        for (Parameter parameter : params) {
            if (parameter.isAnnotationPresent(com.talker.websocketlibrary.reflections.annotations.Payload.class) || parameter.getType().isAssignableFrom(payload.getPayloadClass())) {
                actionInvoke.addParameter(new InvokeParameter(payload.getPayloadClass(), payload.getPayloadObject(), 0));
            }
        }
    }
}
