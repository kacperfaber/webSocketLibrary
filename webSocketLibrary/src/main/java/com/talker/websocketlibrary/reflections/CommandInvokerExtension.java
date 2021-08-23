package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

@Component
public class CommandInvokerExtension implements IActionInvokerExtension{
    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent) {
        actionInvoke.addParameter(actionInvoke.getCommand(), Command.class, 0);
    }
}
