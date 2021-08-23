package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class DefaultActionInvoker implements IActionInvoker {
    List<IActionInvokerExtension> extensions;
    IActionInvokeGenerator actionInvokeGenerator;
    IActionInvokerExtensionsInvoker extensionsInvoker;
    IActionMethodParametersGenerator parametersGenerator;

    public DefaultActionInvoker(List<IActionInvokerExtension> extensions, IActionInvokeGenerator actionInvokeGenerator, IActionInvokerExtensionsInvoker extensionsInvoker, IActionMethodParametersGenerator parametersGenerator) {
        this.extensions = extensions;
        this.actionInvokeGenerator = actionInvokeGenerator;
        this.extensionsInvoker = extensionsInvoker;
        this.parametersGenerator = parametersGenerator;
    }

    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command, HandlerEvent handlerEvent) throws InvocationTargetException, IllegalAccessException {
        final ActionInvoke actionInvoke = actionInvokeGenerator.generate(actionModel, command);
        extensionsInvoker.invokeAll(extensions, actionInvoke, controller, handlerEvent);
        Object[] params = parametersGenerator.generate(actionModel.method, actionInvoke.getParameters());
        actionModel.method.invoke(controller, params);
    }
}
