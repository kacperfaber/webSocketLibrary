package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class DefaultActionInvoker implements IActionInvoker {
    List<IActionInvokerExtension> extensions;
    IActionInvokeGenerator actionInvokeGenerator;
    IActionInvokerExtensionsInvoker extensionsInvoker;

    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command) throws InvocationTargetException, IllegalAccessException {
        final ActionInvoke actionInvoke = actionInvokeGenerator.generate(actionModel);
        extensionsInvoker.invokeAll(extensions, actionInvoke, actionModel, command, controller);
    }
}
