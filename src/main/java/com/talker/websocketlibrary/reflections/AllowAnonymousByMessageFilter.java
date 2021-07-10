package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllowAnonymousByMessageFilter implements IActionModelByMessageFilter{
    @Override
    public List<ActionModel> filter(List<ActionModel> actionModels, Message message) {
        if (message.getUserId() == null) {
            return actionModels.stream().filter(x -> x.allowAnonymousAnnotation != null).collect(Collectors.toList());
        }
        return actionModels;
    }
}
