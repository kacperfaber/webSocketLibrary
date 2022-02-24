package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.List;

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
