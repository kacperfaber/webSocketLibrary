package com.talker.websocketlibrary;

public class ClientMessage extends Message{
    public String clientId;

    public ClientMessage(String rawText) {
        super(rawText);
    }
}
