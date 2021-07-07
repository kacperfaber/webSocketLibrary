package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface IActionModelByCommandFilter {
    List<ActionModel> filter(List<ActionModel> actionModels, CommandModel commandModel);
}
