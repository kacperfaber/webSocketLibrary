package com.talker.websocketlibrary.authorization;

public interface IAccessTokenDeserializer {
    AccessToken deserialize(String decodedString);
}
