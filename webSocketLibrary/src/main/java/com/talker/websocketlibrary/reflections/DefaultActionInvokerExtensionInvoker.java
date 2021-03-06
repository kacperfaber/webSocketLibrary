package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

@Component
public class DefaultActionInvokerExtensionInvoker implements IActionInvokerExtensionInvoker{
    @Override
    public void invoke(IActionInvokerExtension extension, ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) throws Exception{
        extension.beforeInvoke(actionInvoke, controller, handlerEvent, payload);
    }
}
