package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ActionModelsProvider implements IActionModelsProvider {
    public IAllClassesProvider classesProvider;
    public IActionModelLoader actionModelLoader;
    public IActionMethodCandidatesProvider methodsProvider;

    public ActionModelsProvider(IAllClassesProvider classesProvider, IActionModelLoader actionModelLoader, IActionMethodCandidatesProvider methodsProvider) {
        this.classesProvider = classesProvider;
        this.actionModelLoader = actionModelLoader;
        this.methodsProvider = methodsProvider;
    }

    @Override
    public List<ActionModel> provide() {
        List<ActionModel> actionModels = new ArrayList<>();
        Set<Class<?>> classes = classesProvider.provide();
        for (Class<?> c : classes) {
            for (Method method : methodsProvider.provide(c)){
                actionModels.add(actionModelLoader.load(method, c));
            }
        }
        return actionModels;
    }
}
