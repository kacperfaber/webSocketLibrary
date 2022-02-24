package com.talker.websocketlibrary.commons;

import com.talker.websocketlibrary.messaging.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component
public class ServerSingleton {
    private InMemoryStorage inMemoryStorage;

    public InMemoryStorage getInMemoryStorage() {
        if (inMemoryStorage == null) {
            inMemoryStorage = new InMemoryStorage();
        }
        return inMemoryStorage;
    }
}
