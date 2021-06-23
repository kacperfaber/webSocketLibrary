package com.talker.websocketlibrary.authorization;

import java.util.Base64;
import java.util.Optional;

public class SimpleAccessTokenStringDecoder implements IAccessTokenStringDecoder{
    @Override
    public Optional<String> decode(String accessToken) {
        return Optional.of(new String(Base64.getDecoder().decode(accessToken)));
    }
}
