package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.MessageService;
import com.talker.websocketlibrary.reflections.exceptions.ActionInvokerException;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class DefaultActionInvoker implements IActionInvoker {
    List<IActionInvokerExtension> extensions;
    IActionInvokeGenerator actionInvokeGenerator;
    IActionInvokerExtensionsInvoker extensionsInvoker;
    IActionMethodParametersGenerator parametersGenerator;
    IExceptionHandler exceptionHandler;

    public DefaultActionInvoker(List<IActionInvokerExtension> extensions, IActionInvokeGenerator actionInvokeGenerator, IActionInvokerExtensionsInvoker extensionsInvoker, IActionMethodParametersGenerator parametersGenerator, MessageService messageService) {
        this.extensions = extensions;
        this.actionInvokeGenerator = actionInvokeGenerator;
        this.extensionsInvoker = extensionsInvoker;
        this.parametersGenerator = parametersGenerator;
    }

    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command, HandlerEvent handlerEvent) {
        final ActionInvoke actionInvoke = actionInvokeGenerator.generate(actionModel, command);
        try {
            extensionsInvoker.invokeAll(extensions, actionInvoke, controller, handlerEvent);
            Object[] params = parametersGenerator.generate(actionModel.method, actionInvoke.getParameters());
            actionModel.method.invoke(controller, params);
        }
        catch (Exception e) {
            exceptionHandler.handle(e, actionInvoke, handlerEvent);
        }
    }
}
