package com.talker.websocketlibrary.authentication;

public interface IPasswordHasher {
    String hash(String password);
}
