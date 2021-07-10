package com.talker.websocketlibrary.reflections;

import java.util.List;

public class ActionInvoke {
    final List<InvokeParameter> parameters;
    final ActionModel actionModel;

    public ActionInvoke(List<InvokeParameter> parameters, ActionModel actionModel) {
        this.parameters = parameters;
        this.actionModel = actionModel;
    }

    public ActionModel getActionModel() {
        return actionModel;
    }

    public List<InvokeParameter> getParameters() {
        return parameters;
    }

    public <T> void addParameter(T obj, Class<T> cl) {
        parameters.add(new InvokeParameter(cl, obj));
    }
}
