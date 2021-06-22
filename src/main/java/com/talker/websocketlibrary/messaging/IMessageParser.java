package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.Message;
import com.talker.websocketlibrary.MessageWithData;

public interface IMessageParser {
    Message read(String text, String userId);

    <T> MessageWithData<T> read(String text, String userId, Class<T> dataClass);
}
