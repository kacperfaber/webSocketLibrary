package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface IActionModelsFilteredByCommandModelProvider {
    List<ActionModel> provide(Model model, CommandModel commandModel);
}
