package com.talker.websocketlibrary.authorization;

import java.util.Optional;

public interface IAccessTokenReader {
    Optional<AccessToken> read(String accessToken);
}
