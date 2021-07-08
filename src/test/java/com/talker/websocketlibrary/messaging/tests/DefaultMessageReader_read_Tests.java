package com.talker.websocketlibrary.messaging.tests;

import com.talker.websocketlibrary.messaging.DefaultMessageReader;
import com.talker.websocketlibrary.messaging.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DefaultMessageReader_read_Tests {
    Message exec(String text, String userId) {
        DefaultMessageReader reader = new DefaultMessageReader();
        return reader.read(text, userId);
    }

    @Test
    public void dontThrows() {
        Assertions.assertDoesNotThrow(() -> exec("message-name hello", ""));
    }
}
