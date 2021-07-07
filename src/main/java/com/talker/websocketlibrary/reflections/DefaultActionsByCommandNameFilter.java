package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultActionsByCommandNameFilter implements IActionsByCommandNameFilter {

    @Override
    public List<ActionModel> filter(List<ActionModel> actionModels, String commandName) {
        return actionModels.stream().filter(x -> x.socketActionAnnotation.value().equalsIgnoreCase(commandName)).collect(Collectors.toList());
    }
}
