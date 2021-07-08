package com.talker.websocketlibrary.messaging.tests;

import com.talker.websocketlibrary.messaging.DefaultMessageReader;
import com.talker.websocketlibrary.messaging.MessagePrototype;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DefaultMessageReader_read_Tests {
    MessagePrototype exec(String text) throws Exception{
        DefaultMessageReader reader = new DefaultMessageReader();
        return reader.read(text);
    }

    @Test
    public void dontThrows() {
        Assertions.assertDoesNotThrow(() -> exec("message-name hello"));
    }
}
