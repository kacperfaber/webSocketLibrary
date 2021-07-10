package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.binding.BindingResult;
import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.reflections.annotations.Payload;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Component
public class PayloadInvokerExtension implements IActionInvokerExtension{
    IDataBinder binder;

    public PayloadInvokerExtension(IDataBinder binder) {
        this.binder = binder;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller) {
        Parameter firstParam = actionModel.method.getParameters()[0];
        if (firstParam.getAnnotation(Payload.class) != null) {
            BindingResult<?> bindingResult = binder.bind(command.getDataText(), firstParam.getType());
            actionInvoke.parameters.add(new InvokeParameter(bindingResult.dataClass, bindingResult.data, 0));
        }
    }
}
