package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public abstract class ModelLoader {
    public IControllerClassesProvider controllerClassesProvider;
    public IActionMethodsProvider methodsProvider;
    public IActionModelLoader actionModelLoader;

    public Model load() {
        List<ActionModel> actionModels = new ArrayList<>();
        Set<Class<? extends ControllerBase>> controllers = controllerClassesProvider.provide();
        for (Class<? extends ControllerBase> controllerClass : controllers) {
            for (Method method : methodsProvider.provide(controllerClass)){
                actionModels.add(actionModelLoader.load(method, controllerClass));
            }
        }
    }
}
