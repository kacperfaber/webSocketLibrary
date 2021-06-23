package com.talker.websocketlibrary.authorization;

import java.util.Optional;

public class AccessTokenReader implements IAccessTokenReader{
    public IAccessTokenStringDecoder stringDecoder;
    public IAccessTokenDeserializer deserializer;
    @Override
    public Optional<AccessToken> read(String accessToken) {
        Optional<String> optionalString = stringDecoder.decode(accessToken);
        return optionalString.map(s -> deserializer.deserialize(s));
    }
}
