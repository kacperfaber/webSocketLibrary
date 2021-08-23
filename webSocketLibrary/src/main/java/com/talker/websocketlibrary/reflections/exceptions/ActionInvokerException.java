package com.talker.websocketlibrary.reflections.exceptions;

public class ActionInvokerException extends Exception{
    public Object object;

    public ActionInvokerException(Object object) {
        this.object = object;
    }
}
