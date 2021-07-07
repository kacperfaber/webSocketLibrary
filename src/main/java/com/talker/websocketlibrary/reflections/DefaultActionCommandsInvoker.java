package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActionCommandsInvoker implements IActionCommandsInvoker {
    IActionsByCommandNameFilter actionsByCommandNameFilter;
    @Override
    public void invokeAll(Model model, String commandName) {
        // How I have to invoke command, if don't have full command. TODO
        List<ActionModel> actionsToInvoke = actionsByCommandNameFilter.filter(model.actions, commandName); // Make more filters OC Principle TODO
    }
}
