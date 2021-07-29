package com.talker.websocketlibrary.messaging;

public class MessagePrototype {
    final String name, data, rawText;

    public MessagePrototype(String name, String data, String rawText) {
        this.name = name;
        this.data = data;
        this.rawText = rawText;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getRawText() {
        return rawText;
    }
}
