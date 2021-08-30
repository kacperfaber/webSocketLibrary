package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.binding.BindingResult;
import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.annotations.ActionInvokerExtension;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Component
public class PayloadInvokerExtension implements IActionInvokerExtension {
    IDataBinder dataBinder;

    public PayloadInvokerExtension(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) {
        if (payload.getPayloadClass() != Object.class) {
            actionInvoke.addParameter(new InvokeParameter(payload.getPayloadClass(), payload.getPayloadObject(), 0, ParameterKind.Payload));
        }
        else {
            for (Parameter p : actionInvoke.getActionModel().method.getParameters()) {
                if (p.isAnnotationPresent(com.talker.websocketlibrary.reflections.annotations.Payload.class)) {
                    Class<?> parameterClass = p.getType();
                    BindingResult<?> bindingResult = dataBinder.bind(actionInvoke.getCommand().getDataText(), parameterClass);
                    actionInvoke.addParameter(new InvokeParameter(parameterClass, bindingResult.data, 0, ParameterKind.Payload));
                }
            }
        }
    }
}
