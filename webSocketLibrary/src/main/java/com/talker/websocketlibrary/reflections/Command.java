package com.talker.websocketlibrary.reflections;

public class Command {
    final String name, rawText, dataText, sessionId;
    final Object userId;

    public Command(String name, String rawText, String dataText, Object userId, String sessionId) {
        this.name = name;
        this.rawText = rawText;
        this.dataText = dataText;
        this.userId = userId;
        this.sessionId = sessionId;
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

    public Object getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
