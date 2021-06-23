package com.talker.websocketlibrary.authorization;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorizationService {
    public IAccessTokenReader tokenReader;
    public List<IAccessTokenValidator> validators;

    public AuthorizationService(IAccessTokenReader tokenReader, List<IAccessTokenValidator> validators) {
        this.tokenReader = tokenReader;
        this.validators = validators;
    }

    public AuthorizationResult authorize(String accessTokenString) {
        final Optional<AccessToken> optionalAccessToken = tokenReader.read(accessTokenString);
        if (optionalAccessToken.isPresent()) {
            AccessToken accessToken = optionalAccessToken.get();
            for (IAccessTokenValidator validator : validators) {
                if (!validator.validate(accessToken)) {
                    return new AuthorizationResult(false);
                }
            }
            return new AuthorizationResult(true);
        }
        return new AuthorizationResult(false);
    }
}
