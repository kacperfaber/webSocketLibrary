package com.talker.websocketlibrary.authorization;

import java.util.Optional;

public interface IAccessTokenStringDecoder {
    Optional<String> decode(String accessToken);
}
