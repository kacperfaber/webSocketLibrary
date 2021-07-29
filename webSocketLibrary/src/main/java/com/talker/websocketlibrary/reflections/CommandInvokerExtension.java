package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

@Component
public class CommandInvokerExtension implements IActionInvokerExtension{
    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller, HandlerEvent handlerEvent) {
        actionInvoke.addParameter(command, Command.class, 0);
    }
}
