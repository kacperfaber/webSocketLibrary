package com.talker.websocketlibrary.messaging;

public class Message {
    final String name;
    final String rawText;
    final String dataText;
    final String userId;

    public Message(String name, String dataText, String rawText, String userId) {
        this.name = name;
        this.dataText = dataText;
        this.rawText = rawText;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getRawText() {
        return rawText;
    }

    public String getDataText() {
        return dataText;
    }

    public String getUserId() {
        return userId;
    }
}
