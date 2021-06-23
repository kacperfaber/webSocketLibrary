package com.talker.websocketlibrary.authorization;

public class AuthorizationResult {
    final boolean success;

    public AuthorizationResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
