package com.talker.websocketlibrary.messaging;

import java.util.List;

public interface IMessagesToSendProvider {
    List<MessageToSend> provide(String userId);
}
