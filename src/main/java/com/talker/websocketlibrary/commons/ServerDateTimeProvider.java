package com.talker.websocketlibrary.commons;

import java.time.LocalDateTime;

public class ServerDateTimeProvider implements IServerDateTimeProvider{
    @Override
    public LocalDateTime provide() {
        return LocalDateTime.now();
    }
}
