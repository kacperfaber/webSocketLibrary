package com.talker.websocketlibrary.reflections;

public interface IPayloadGenerator {
    Payload generate(Class<?> payloadClass, Object payloadObject);
}
