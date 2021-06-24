package com.talker.websocketlibrary.messaging;

public class MessageToSend implements Comparable<MessageToSend> {
    public final Integer index;
    final String messageRaw;
    final String userId;

    public MessageToSend(String messageRaw, String userId, int index) {
        this.messageRaw = messageRaw;
        this.userId = userId;
        this.index = index;
    }

    public String getMessageRaw() {
        return messageRaw;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public int compareTo(MessageToSend o) {
        return index.compareTo(o.index);
    }
}
