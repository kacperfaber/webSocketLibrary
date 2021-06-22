package com.talker.websocketlibrary;

public class ResponseMessage extends Message {

    String targetUserId;

    public ResponseMessage(String rawText, String targetUserId) {
        super(rawText);
    }

    public String getTargetUserId() {
        return targetUserId;
    }
}
