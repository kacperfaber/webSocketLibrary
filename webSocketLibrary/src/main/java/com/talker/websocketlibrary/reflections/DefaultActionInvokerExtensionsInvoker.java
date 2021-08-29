package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.exceptions.ActionInvokerException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActionInvokerExtensionsInvoker implements  IActionInvokerExtensionsInvoker{
    IActionInvokerExtensionInvoker invoker;

    public DefaultActionInvokerExtensionsInvoker(IActionInvokerExtensionInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void invokeAll(List<IActionInvokerExtension> extensions, ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) throws ActionInvokerException, Exception{
        for (IActionInvokerExtension extension : extensions) {
            invoker.invoke(extension, actionInvoke, controller, handlerEvent, payload);
        }
    }
}
