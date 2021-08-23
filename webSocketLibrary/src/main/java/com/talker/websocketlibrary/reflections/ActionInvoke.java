package com.talker.websocketlibrary.reflections;

import java.util.ArrayList;
import java.util.List;

public class ActionInvoke {
    final List<InvokeParameter> parameters;
    final ActionModel actionModel;
    final Command command;

    public ActionInvoke(List<InvokeParameter> parameters, ActionModel actionModel, Command command) {
        this.parameters = parameters;
        this.actionModel = actionModel;
        this.command = command;
    }

    public ActionModel getActionModel() {
        return actionModel;
    }

    public <T> void addParameter(T obj, Class<T> cl, int weight) {
        parameters.add(new InvokeParameter(cl, obj, weight));
    }

    public void addParameter(InvokeParameter p) {
        parameters.add(p);
    }

    public List<InvokeParameter> getParameters() {
        return new ArrayList<>(parameters);
    }

    public Command getCommand() {
        return this.command;
    }
}
