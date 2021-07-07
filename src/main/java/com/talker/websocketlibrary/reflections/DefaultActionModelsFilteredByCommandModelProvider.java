package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultActionModelsFilteredByCommandModelProvider implements IActionModelsFilteredByCommandModelProvider {
    List<IActionModelByCommandFilter> filters;

    public DefaultActionModelsFilteredByCommandModelProvider(List<IActionModelByCommandFilter> filters) {
        this.filters = filters;
    }

    @Override
    public List<ActionModel> provide(Model model, CommandModel commandModel) {
        List<ActionModel> actionModels = new ArrayList<>(model.actions);
        for (IActionModelByCommandFilter filter : filters) {
            actionModels = filter.filter(actionModels, commandModel);
        }
    }
}
