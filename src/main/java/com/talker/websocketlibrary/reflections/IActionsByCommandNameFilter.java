package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface IActionsByCommandNameFilter {
    List<ActionModel> filter(List<ActionModel> actionModels, String commandName);
}
