package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.SocketAction;

import java.lang.reflect.Method;

public class ActionModel {
    Class<?> actionClass;
    Method method;
    SocketAction socketActionAnnotation;

    public Class<?> getActionClass() {
        return actionClass;
    }

    public Method getMethod() {
        return method;
    }

    public SocketAction getSocketActionAnnotation() {
        return socketActionAnnotation;
    }
}
