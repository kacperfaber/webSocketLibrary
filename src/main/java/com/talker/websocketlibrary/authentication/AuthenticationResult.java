package com.talker.websocketlibrary.authentication;

import java.util.Optional;

public class AuthenticationResult {
    final boolean success;
    final String userId;

    public AuthenticationResult(boolean success, String userId) {
        this.userId = userId;
        this.success=success;
    }

    public boolean isSuccess() {
        return success;
    }

    public Optional<String> getUserId() {
        return Optional.of(userId);
    }
}
