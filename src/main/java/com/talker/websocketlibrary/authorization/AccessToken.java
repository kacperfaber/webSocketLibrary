package com.talker.websocketlibrary.authorization;

import java.time.LocalDateTime;

public class AccessToken {
    public String userId;
    public LocalDateTime authenticatedAt;
    public String salt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getAuthenticatedAt() {
        return authenticatedAt;
    }

    public void setAuthenticatedAt(LocalDateTime authenticatedAt) {
        this.authenticatedAt = authenticatedAt;
    }
}
