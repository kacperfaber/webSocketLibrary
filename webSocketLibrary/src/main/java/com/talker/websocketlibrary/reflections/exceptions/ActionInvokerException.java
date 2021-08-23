package com.talker.websocketlibrary.reflections.exceptions;

public class ActionInvokerException extends Exception {
    final Object object;
    final String messageName;
    final Class<Object> objectClass;

    public ActionInvokerException(String messageName, Object object, Class<Object> objectClass) {
        this.messageName = messageName;
        this.object = object;
        this.objectClass = objectClass;
    }

    public String getMessageName() {
        return this.messageName;
    }

    public Object getObject() {
        return this.object;
    }

    public Class<Object> getObjectClass() {
        return this.objectClass;
    }
}
