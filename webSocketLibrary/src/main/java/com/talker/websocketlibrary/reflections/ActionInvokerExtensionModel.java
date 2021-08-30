package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.ActionInvokerExtension;

public class ActionInvokerExtensionModel {
    public IActionInvokerExtension object;
    public ActionInvokerExtension annotation;

    public ActionInvokerExtensionModel(IActionInvokerExtension object, ActionInvokerExtension annotation) {
        this.object = object;
        this.annotation = annotation;
    }

    public IActionInvokerExtension getObject() {
        return object;
    }

    public ActionInvokerExtension getAnnotation() {
        return annotation;
    }
}
