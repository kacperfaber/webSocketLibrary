package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllowAnonymousByMessageFilter implements IActionModelByMessageFilter{
    @Override
    public List<ActionModel> filter(List<ActionModel> actionModels, Message message) {
        return actionModels.stream().filter(x -> (message.getUserId() == null && x.allowAnonymousAnnotation != null) || (message.getUserId() != null && x.allowAnonymousAnnotation == null)).collect(Collectors.toList());
    }
}
