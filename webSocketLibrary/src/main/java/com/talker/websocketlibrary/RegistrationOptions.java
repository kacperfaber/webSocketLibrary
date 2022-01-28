package com.talker.websocketlibrary;

public class RegistrationOptions {
    public String allowedOrigin, path;

    public RegistrationOptions(String path, String allowedOrigin) {
        this.path = path;
        this.allowedOrigin = allowedOrigin;
    }
}
