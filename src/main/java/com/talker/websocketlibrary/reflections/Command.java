package com.talker.websocketlibrary.reflections;

public abstract class Command {
    final String name, rawText, dataText, userId;

    public Command(String name, String rawText, String dataText, String userId) {
        this.name = name;
        this.rawText = rawText;
        this.dataText = dataText;
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
