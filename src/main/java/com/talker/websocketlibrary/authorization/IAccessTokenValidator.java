package com.talker.websocketlibrary.authorization;

public interface IAccessTokenValidator {
    boolean validate(AccessToken accessToken);
}
