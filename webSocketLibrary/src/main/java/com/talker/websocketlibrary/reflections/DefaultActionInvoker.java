package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.binding.IDataBinder;
import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultActionInvoker implements IActionInvoker {
    IActionInvokeGenerator actionInvokeGenerator;
    IActionInvokerExtensionsInvoker extensionsInvoker;
    IActionMethodParametersGenerator parametersGenerator;
    IExceptionHandler exceptionHandler;
    IPayloadGenerator payloadGenerator;
    IDataBinder dataBinder;
    ISortedActionInvokerExtensionsProvider sortedExtensionsProvider;
    IMethodReturnTypeProvider returnTypeProvider;
    IActionMethodInvoker methodInvoker;
    IMethodInvokerResultInterpreter methodInvokerResultInterpreter;

    public DefaultActionInvoker(IMethodInvokerResultInterpreter methodInvokerResultInterpreter, IActionInvokeGenerator actionInvokeGenerator, IActionInvokerExtensionsInvoker extensionsInvoker, IActionMethodParametersGenerator parametersGenerator, IExceptionHandler exceptionHandler, IPayloadGenerator payloadGenerator, IDataBinder dataBinder, ISortedActionInvokerExtensionsProvider sortedExtensionsProvider, IMethodReturnTypeProvider returnTypeProvider, IActionMethodInvoker methodInvoker) {
        this.actionInvokeGenerator = actionInvokeGenerator;
        this.extensionsInvoker = extensionsInvoker;
        this.parametersGenerator = parametersGenerator;
        this.exceptionHandler = exceptionHandler;
        this.payloadGenerator = payloadGenerator;
        this.dataBinder = dataBinder;
        this.sortedExtensionsProvider = sortedExtensionsProvider;
        this.returnTypeProvider = returnTypeProvider;
        this.methodInvoker = methodInvoker;
        this.methodInvokerResultInterpreter = methodInvokerResultInterpreter;
    }

    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command, HandlerEvent handlerEvent) {
        final ActionInvoke actionInvoke = actionInvokeGenerator.generate(actionModel, command);
        try {
            Payload payload = payloadGenerator.generate(actionModel.getSocketActionAnnotation().payloadClass(), dataBinder.bind(command.getDataText(), actionModel.getSocketActionAnnotation().payloadClass()).data);
            List<ActionInvokerExtensionModel> extensions = sortedExtensionsProvider.provide();
            extensionsInvoker.invokeAll(extensions, actionInvoke, controller, handlerEvent, payload);
            Object[] params = parametersGenerator.generate(actionModel.method, actionInvoke.getParameters());
            Optional<Object> methodInvokerResult = methodInvoker.invoke(actionModel.getMethod(), controller, params);
            methodInvokerResultInterpreter.interpret(methodInvokerResult);
        } catch (Exception e) {
            exceptionHandler.handle(e, actionInvoke, handlerEvent);
        }
    }
}
