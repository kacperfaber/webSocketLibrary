package com.talker.websocketlibrary.authorization;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccessNotIsNotExpiredValidator implements IAccessTokenValidator {


    @Override
    public boolean validate(AccessToken accessToken) {
        if (accessToken.authenticatedAt.isAfter(LocalDateTime.now().minusMinutes(15))) {
            return true;
        }
        return false;
    }
}
