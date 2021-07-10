package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActionInvokerExtensionsInvoker implements  IActionInvokerExtensionsInvoker{
    IActionInvokerExtensionInvoker invoker;

    public DefaultActionInvokerExtensionsInvoker(IActionInvokerExtensionInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void invokeAll(List<IActionInvokerExtension> extensions, ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller) {
        for (IActionInvokerExtension extension : extensions) {
            invoker.invoke(extension, actionInvoke, actionModel, command, controller);
        }
    }
}
