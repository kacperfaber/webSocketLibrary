package com.talker.websocketlibrary.messaging;

public class MessageToSend {
    final String messageRaw;
    final String userId;

    public MessageToSend(String messageRaw, String userId) {
        this.messageRaw = messageRaw;
        this.userId = userId;
    }

    public String getMessageRaw() {
        return messageRaw;
    }

    public String getUserId() {
        return userId;
    }
}
