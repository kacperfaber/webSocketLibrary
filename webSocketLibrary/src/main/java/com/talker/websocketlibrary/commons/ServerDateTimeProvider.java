package com.talker.websocketlibrary.commons;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ServerDateTimeProvider implements IServerDateTimeProvider{
    @Override
    public LocalDateTime provide() {
        return LocalDateTime.now();
    }
}
