package com.talker.websocketlibrary.reflections;

public class InvokeParameter {
    final Class<?> parameterClass;
    final Object parameter;
    final int weigth;
    final ParameterKind parameterKind;

    public InvokeParameter(Class<?> parameterClass, Object parameter, int weigth) {
        this.parameterClass = parameterClass;
        this.parameter = parameter;
        this.weigth = weigth;
        this.parameterKind = ParameterKind.Other;
    }

    public InvokeParameter(Class<?> parameterClass, Object parameter, int weigth, ParameterKind parameterKind) {
        this.parameterClass = parameterClass;
        this.parameter = parameter;
        this.weigth = weigth;
        this.parameterKind = parameterKind;
    }

    public Class<?> getParameterClass() {
        return parameterClass;
    }

    public Object getParameter() {
        return parameter;
    }
}
