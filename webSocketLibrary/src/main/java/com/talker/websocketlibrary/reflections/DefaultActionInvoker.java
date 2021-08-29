package com.talker.websocketlibrary.reflections;

import com.google.gson.Gson;
import com.talker.websocketlibrary.binding.IDataBinder;
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
    IPayloadGenerator payloadGenerator;
    IDataBinder dataBinder;

    public DefaultActionInvoker(List<IActionInvokerExtension> extensions, IActionInvokeGenerator actionInvokeGenerator, IActionInvokerExtensionsInvoker extensionsInvoker, IActionMethodParametersGenerator parametersGenerator, IExceptionHandler exceptionHandler) {
        this.extensions = extensions;
        this.actionInvokeGenerator = actionInvokeGenerator;
        this.extensionsInvoker = extensionsInvoker;
        this.parametersGenerator = parametersGenerator;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command, HandlerEvent handlerEvent) {
        Payload payload = payloadGenerator.generate(actionModel.getSocketActionAnnotation().payloadClass(), dataBinder.bind(command.getDataText(), actionModel.getSocketActionAnnotation().payloadClass()));
        final ActionInvoke actionInvoke = actionInvokeGenerator.generate(actionModel, command);
        try {
            extensionsInvoker.invokeAll(extensions, actionInvoke, controller, handlerEvent, payload);
            Object[] params = parametersGenerator.generate(actionModel.method, actionInvoke.getParameters());
            actionModel.method.invoke(controller, params);
        }
        catch (Exception e) {
            exceptionHandler.handle(e, actionInvoke, handlerEvent);
        }
    }
}
