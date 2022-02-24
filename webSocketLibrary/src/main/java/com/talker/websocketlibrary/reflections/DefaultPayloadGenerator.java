package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

@Component
public class DefaultPayloadGenerator implements IPayloadGenerator {
    @Override
    public Payload generate(Class<?> payloadClass, Object payloadObject) {
        Payload payload = new Payload(payloadClass);
        payload.setPayloadObject(payloadObject);
        return payload;
    }
}
