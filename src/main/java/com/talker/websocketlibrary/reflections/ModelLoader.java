package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.util.Set;

public abstract class ModelLoader {
    public IControllerClassesProvider controllerClassesProvider;

    public Model load() {
        Set<Class<? extends ControllerBase>> controllers = controllerClassesProvider.provide();
        throw new UnsupportedOperationException();
    }
}
