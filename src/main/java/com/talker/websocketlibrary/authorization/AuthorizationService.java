package com.talker.websocketlibrary.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorizationService {
    public IAccessTokenReader tokenReader;

    @Autowired
    public List<IAccessTokenValidator> validators;



    public AuthorizationResult authorize(String accessToken) {
        final Optional<AccessToken> optionalAccessToken = tokenReader.read(accessToken);
        if (optionalAccessToken.isPresent()) {

        }
        return new AuthorizationResult(false);
    }
}
