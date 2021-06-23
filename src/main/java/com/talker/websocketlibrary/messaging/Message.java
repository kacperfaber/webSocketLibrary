package com.talker.websocketlibrary.messaging;

public class Message {
    final String name;
    final String rawText;
    final String dataText;


    public Message(String name, String dataText, String rawText) {
        this.name = name;
        this.dataText = dataText;
        this.rawText = rawText;
    }
}
