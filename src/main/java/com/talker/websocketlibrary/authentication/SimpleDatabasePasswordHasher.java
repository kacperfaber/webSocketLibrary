package com.talker.websocketlibrary.authentication;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SimpleDatabasePasswordHasher implements IPasswordHasher {
    @Override
    public String hash(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }
}
