package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

@Component
public class PerRequestControllerInvokerExtension implements IActionInvokerExtension {
    IPerRequestControllerGenerator controllerGenerator;

    public PerRequestControllerInvokerExtension(IPerRequestControllerGenerator controllerGenerator) {
        this.controllerGenerator = controllerGenerator;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller, HandlerEvent handlerEvent) {
        actionInvoke.addParameter(controllerGenerator.generate(handlerEvent.getSession()), PerRequestController.class, 0);
    }
}
