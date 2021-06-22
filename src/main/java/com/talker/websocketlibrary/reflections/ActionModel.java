package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.lang.reflect.Method;

public class ActionModel {
    Class<? extends ControllerBase> controllerClass;
    Method method;
    Action actionAnnotation;
}
