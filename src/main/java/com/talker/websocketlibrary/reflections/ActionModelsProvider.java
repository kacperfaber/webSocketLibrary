package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionModelsProvider implements IActionModelsProvider {
    public IControllerClassesProvider classesProvider;
    public IActionModelLoader actionModelLoader;
    public IActionMethodCandidatesProvider methodsProvider;

    @Override
    public List<ActionModel> provide() {
        List<ActionModel> actionModels = new ArrayList<>();
        Set<Class<? extends ControllerBase>> controllers = classesProvider.provide();
        for (Class<? extends ControllerBase> controllerClass : controllers) {
            for (Method method : methodsProvider.provide(controllerClass)){
                actionModels.add(actionModelLoader.load(method, controllerClass));
            }
        }
        return actionModels;
    }
}
