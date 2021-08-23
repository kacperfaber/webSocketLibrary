package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.binding.BindingResult;
import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.annotations.Payload;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Component
public class PayloadInvokerExtension implements IActionInvokerExtension {
    IDataBinder binder;

    public PayloadInvokerExtension(IDataBinder binder) {
        this.binder = binder;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent) {
        Parameter[] params = actionInvoke.getActionModel().method.getParameters();
        for (Parameter parameter : params) {
            if (parameter.isAnnotationPresent(Payload.class)) {
                BindingResult<?> bindingResult = binder.bind(actionInvoke.getCommand().getDataText(), parameter.getType());
                actionInvoke.parameters.add(new InvokeParameter(bindingResult.dataClass, bindingResult.data, 0));
            }
        }
    }
}
