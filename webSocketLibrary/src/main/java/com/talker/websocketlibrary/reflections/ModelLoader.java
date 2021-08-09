package com.talker.websocketlibrary.reflections;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ModelLoader {
    public IActionModelsProvider modelsProvider;

    public ModelLoader(IActionModelsProvider modelsProvider) {
        this.modelsProvider = modelsProvider;
    }

    public Model load(String prefix) {
        List<ActionModel> actionModels = modelsProvider.provide(prefix);
        Model model = new Model();
        model.actions = actionModels;
        return model;
    }
}
