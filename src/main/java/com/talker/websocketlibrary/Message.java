package com.talker.websocketlibrary;

public abstract class Message {
    String rawText;

    public Message(String rawText) {
        this.rawText = rawText;
    }

    public String getRawText() {
        return rawText;
    }
}
