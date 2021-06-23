package com.talker.websocketlibrary.messaging;

import java.time.LocalDateTime;

public abstract class Session {
    final String userId;
    final LocalDateTime connectedAt;

    public Session(String userId, LocalDateTime connectedAt) {
        this.userId = userId;
        this.connectedAt = connectedAt;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getConnectedAt() {
        return connectedAt;
    }
}
