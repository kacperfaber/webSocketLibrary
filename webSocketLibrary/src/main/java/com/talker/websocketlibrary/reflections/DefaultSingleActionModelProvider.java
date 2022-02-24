package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultSingleActionModelProvider implements ISingleActionModelProvider {
    @Override
    public ActionModel provide(List<ActionModel> actionModels, String commandName) throws Exception {
        if (actionModels.size() > 1) {
            throw new Exception("Too much actions are matching to command '" + commandName + "'");
        }
        return actionModels.get(0);
    }
}
