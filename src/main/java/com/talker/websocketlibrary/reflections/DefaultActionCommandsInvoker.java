package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActionCommandsInvoker implements IActionCommandsInvoker {
    IActionModelsFilteredByMessageProvider filteredActionModelsProvider;
    @Override
    public void invokeAll(Model model, Message message) {
        List<ActionModel> actionModels = filteredActionModelsProvider.provide(model, message);
        for (ActionModel actionModel : actionModels) {

        }
    }
}
