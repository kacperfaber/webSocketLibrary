package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.AllowAnonymous;
import com.talker.websocketlibrary.reflections.annotations.SocketAction;

import java.lang.reflect.Method;

public class ActionModel {
    Class<?> actionClass;
    Method method;
    SocketAction socketActionAnnotation;
    AllowAnonymous allowAnonymousAnnotation;
}
