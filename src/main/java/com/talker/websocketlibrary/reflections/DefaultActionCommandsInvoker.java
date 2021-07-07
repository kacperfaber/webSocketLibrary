package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultActionCommandsInvoker implements IActionCommandsInvoker {
    IActionModelsFilteredByCommandModelProvider filteredActionModelsProvider;
    @Override
    public void invokeAll(Model model, CommandModel commandModel) {
        List<ActionModel> actionModels = filteredActionModelsProvider.provide(model, commandModel);

    }
}
