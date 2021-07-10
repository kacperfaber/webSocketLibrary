package com.talker.websocketlibrary.reflections;

public class InvokeParameter {
    final Class<?> parameterClass;
    final Object parameter;

    public InvokeParameter(Class<?> parameterClass, Object parameter) {
        this.parameterClass = parameterClass;
        this.parameter = parameter;
    }

    public Class<?> getParameterClass() {
        return parameterClass;
    }

    public Object getParameter() {
        return parameter;
    }
}
