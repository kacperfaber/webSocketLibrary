package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.lang.reflect.Method;

public class DefaultActionModelLoader implements IActionModelLoader{
    @Override
    public ActionModel load(Method method, Class<? extends ControllerBase> controllerClass) {
        ActionModel action = new ActionModel();
        action.method = method;
        action.controllerClass = controllerClass;
        action.actionAnnotation = method.getAnnotation(Action.class);
        return action;
    }
}
