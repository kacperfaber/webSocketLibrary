package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActionModelByCommandNameFilter implements IActionModelByMessageFilter {
    @Override
    public List<ActionModel> filter(List<ActionModel> actionModels, Message message) {
        return actionModels.stream().filter(x -> x.socketActionAnnotation.value().equalsIgnoreCase(message.getName())).collect(Collectors.toList());
    }
}
