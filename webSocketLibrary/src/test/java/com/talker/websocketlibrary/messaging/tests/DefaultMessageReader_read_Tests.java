package com.talker.websocketlibrary.messaging.tests;

import com.talker.websocketlibrary.messaging.DefaultMessageReader;
import com.talker.websocketlibrary.messaging.MessagePrototype;
import org.junit.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultMessageReader_read_Tests {
    MessagePrototype exec(String text) throws Exception {
        DefaultMessageReader reader = new DefaultMessageReader();
        return reader.readMessage(text);
    }

    @Test
    public void dontThrows() {
        assertDoesNotThrow(() -> exec("message-name hello"));
    }

    @Test
    public void notNull() throws Exception {
        assertNotNull(exec("message-name hello"));
    }

    @Test
    public void expectedName() throws Exception{
        final String expected = UUID.randomUUID().toString();
        assertEquals(expected, exec(expected + " hello").getName());
    }

    @Test
    public void expectedData() throws Exception{
        final String expected = UUID.randomUUID().toString();
        assertEquals(expected, exec("message-name " + expected).getData());
    }

    @Test
    public void throwsIfDoesntContainWhiteSpace() throws Exception{
        assertThrows(Exception.class, () -> exec("message-name"));
    }
}
