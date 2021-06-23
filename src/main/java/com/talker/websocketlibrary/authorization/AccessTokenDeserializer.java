package com.talker.websocketlibrary.authorization;

import com.google.gson.Gson;

public class AccessTokenDeserializer implements IAccessTokenDeserializer{
    final Gson gson = new Gson();
    @Override
    public AccessToken deserialize(String decodedString) {
        return gson.fromJson(decodedString, AccessToken.class);
    }
}
