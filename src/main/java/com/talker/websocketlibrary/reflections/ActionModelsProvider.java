package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ActionModelsProvider implements IActionModelsProvider {
    public IControllerClassesProvider classesProvider;
    public IActionModelLoader actionModelLoader;
    public IActionMethodCandidatesProvider methodsProvider;

    public ActionModelsProvider(IControllerClassesProvider classesProvider, IActionModelLoader actionModelLoader, IActionMethodCandidatesProvider methodsProvider) {
        this.classesProvider = classesProvider;
        this.actionModelLoader = actionModelLoader;
        this.methodsProvider = methodsProvider;
    }

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
