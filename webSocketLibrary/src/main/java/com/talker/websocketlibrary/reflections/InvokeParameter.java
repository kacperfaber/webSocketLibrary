package com.talker.websocketlibrary.reflections;

public class InvokeParameter {
    final Class<?> parameterClass;
    final Object parameter;
    final int weigth;

    public InvokeParameter(Class<?> parameterClass, Object parameter, int weigth) {
        this.parameterClass = parameterClass;
        this.parameter = parameter;
        this.weigth = weigth;
    }

    public Class<?> getParameterClass() {
        return parameterClass;
    }

    public Object getParameter() {
        return parameter;
    }
}
