package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class DefaultActionCommandsInvoker implements IActionCommandsInvoker {
    IActionModelsFilteredByMessageProvider filteredActionModelsProvider;
    IActionModelInvoker actionInvoker;
    IControllerProvider controllerProvider;
    ICommandGenerator commandGenerator;

    public DefaultActionCommandsInvoker(IActionModelsFilteredByMessageProvider filteredActionModelsProvider, IActionModelInvoker actionInvoker, IControllerProvider controllerProvider, ICommandGenerator commandGenerator) {
        this.filteredActionModelsProvider = filteredActionModelsProvider;
        this.actionInvoker = actionInvoker;
        this.controllerProvider = controllerProvider;
        this.commandGenerator = commandGenerator;
    }

    @Override
    public void invokeAll(Model model, Message message, HandlerEvent handlerEvent) throws InvocationTargetException, IllegalAccessException {
        List<ActionModel> actionModels = filteredActionModelsProvider.provide(model, message);
        for (ActionModel actionModel : actionModels) {
            actionInvoker.invoke(actionModel, controllerProvider.provide(actionModel.actionClass), commandGenerator.generate(message, handlerEvent));
        }
    }
}
