package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActionCommandInvoker implements IActionCommandInvoker {
    IActionModelsFilteredByMessageProvider filteredActionModelsProvider;
    IActionInvoker actionInvoker;
    IControllerProvider controllerProvider;
    ICommandGenerator commandGenerator;
    ISingleActionModelProvider singleActionModelProvider;

    public DefaultActionCommandInvoker(IActionModelsFilteredByMessageProvider filteredActionModelsProvider, IActionInvoker actionInvoker, IControllerProvider controllerProvider, ICommandGenerator commandGenerator, ISingleActionModelProvider singleActionModelProvider) {
        this.filteredActionModelsProvider = filteredActionModelsProvider;
        this.actionInvoker = actionInvoker;
        this.controllerProvider = controllerProvider;
        this.commandGenerator = commandGenerator;
        this.singleActionModelProvider = singleActionModelProvider;
    }

    @Override
    public void invoke(Model model, Message message, HandlerEvent handlerEvent) throws Exception {
        List<ActionModel> actionModels = filteredActionModelsProvider.provide(model, message);
        ActionModel actionModel = singleActionModelProvider.provide(actionModels, message.getName());
        actionInvoker.invoke(actionModel, controllerProvider.provide(actionModel.actionClass), commandGenerator.generate(message, handlerEvent), handlerEvent);
    }
}
