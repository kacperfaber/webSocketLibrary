package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.commons.ServerSingleton;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DefaultMessageToSendProvider implements IMessagesToSendProvider{
    ServerSingleton serverSingleton;
    @Override
    public List<MessageToSend> provide(String userId) {
        List<MessageToSend> list = serverSingleton.
                getInMemoryStorage().
                getMessageToSendList().
                stream().
                filter(x -> x.userId.equals(userId)).
                toList();
        Collections.sort(list);
        return list;
    }
}
