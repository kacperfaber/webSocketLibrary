package com.talker.websocketlibrary.reflections;

public class Payload {
    final Class<?> payloadClass;
    private Object payloadObject;
    public Payload(Class<?> payloadClass) {
        this.payloadClass = payloadClass;
    }

    public Class<?> getPayloadClass() {
        return payloadClass;
    }

    public Object getPayloadObject() {
        return payloadObject;
    }

    public void setPayloadObject(Object payloadObject) {
        this.payloadObject = payloadObject;
    }
}
