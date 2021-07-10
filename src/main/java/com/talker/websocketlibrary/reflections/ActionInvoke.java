package com.talker.websocketlibrary.reflections;

import java.util.List;

public class ActionInvoke {
    final List<InvokeParameter> parameters;

    public ActionInvoke(List<InvokeParameter> parameters) {
        this.parameters = parameters;
    }

    public List<InvokeParameter> getParameters() {
        return parameters;
    }

    public <T> void addParameter(T obj, Class<T> cl) {
        parameters.add(new InvokeParameter(cl, obj));
    }
}
