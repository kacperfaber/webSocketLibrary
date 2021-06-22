package com.talker.websocketlibrary;

public class Message {
    final String name;
    final String dataText;

    public Message(String name, String dataText) {
        this.name = name;
        this.dataText = dataText;
    }

    public String getRawText() {
        return dataText;
    }

    public String getName() { return name; }
}
