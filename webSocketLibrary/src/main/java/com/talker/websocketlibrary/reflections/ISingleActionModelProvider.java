package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface ISingleActionModelProvider {
    ActionModel provide(List<ActionModel> actionModels, String commandName) throws Exception;
}
