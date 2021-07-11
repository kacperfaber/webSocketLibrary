package com.talker.websocketlibrary.reflections;

public interface IPerRequestControllerGenerator {
    PerRequestController generate(String sessionId);
}
