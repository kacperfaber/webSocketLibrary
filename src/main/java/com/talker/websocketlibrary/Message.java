package com.talker.websocketlibrary;

public abstract class Message {
    protected String rawText;

    public Message(String rawText) {
        this.rawText = rawText;
    }

    public String getRawText() {
        return rawText;
    }
}
