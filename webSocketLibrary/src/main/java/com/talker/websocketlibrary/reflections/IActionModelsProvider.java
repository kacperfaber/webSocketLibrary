package com.talker.websocketlibrary.reflections;

import org.reflections.Reflections;

import java.util.List;

public interface IActionModelsProvider {
    List<ActionModel> provide();
}
