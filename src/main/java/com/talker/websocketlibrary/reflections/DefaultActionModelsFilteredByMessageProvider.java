package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultActionModelsFilteredByMessageProvider implements IActionModelsFilteredByMessageProvider {
    List<IActionModelByMessageFilter> filters;

    public DefaultActionModelsFilteredByMessageProvider(List<IActionModelByMessageFilter> filters) {
        this.filters = filters;
    }

    @Override
    public List<ActionModel> provide(Model model, Message message) {
        List<ActionModel> actionModels = new ArrayList<>(model.actions);
        for (IActionModelByMessageFilter filter : filters) {
            actionModels = filter.filter(actionModels, message);
        }
        return actionModels;
    }
}
