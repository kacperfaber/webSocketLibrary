package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface IActionModelsProvider {
    List<ActionModel> provide(String prefix);
}
