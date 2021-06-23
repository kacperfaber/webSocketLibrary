package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ModelLoader {
    public IActionModelsProvider modelsProvider;

    public Model load() {
        List<ActionModel> actionModels = modelsProvider.provide();
        Model model = new Model();
        model.actions = actionModels;
        return model;
    }
}
