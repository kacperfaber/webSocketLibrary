package com.talker.websocketlibrary.authentication;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class SimpleDatabasePasswordHasher implements IPasswordHasher {
    @Override
    public String hash(String password) {
        return password;
    }
}
