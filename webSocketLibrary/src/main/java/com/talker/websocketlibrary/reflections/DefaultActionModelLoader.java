package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.SocketAction;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DefaultActionModelLoader implements IActionModelLoader {
    @Override
    public ActionModel load(Method method, Class<?> actionClass) {
        ActionModel action = new ActionModel();
        action.method = method;
        action.actionClass = actionClass;
        action.socketActionAnnotation = method.getAnnotation(SocketAction.class);
        return action;
    }
}
