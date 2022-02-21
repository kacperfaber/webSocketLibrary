package com.talker.websocketlibrary.tests;

import com.talker.websocketlibrary.ControllerBase;
import com.talker.websocketlibrary.reflections.BroadcastResult;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

public class ControllerBase_broadcastResult_Tests {
    class Controller extends ControllerBase {
    }

    <T> BroadcastResult exec(String name, T data, Class<T> dataClass) {
        return new Controller().broadcastResult(name, data, dataClass);
    }

    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec("name", new Object(), Object.class));
    }

    @Test
    public void notNull() {
        Assertions.assertNotNull(exec("name", new Object(), Object.class));
    }

    @Test
    public void expectedName() {
        String r = UUID.randomUUID().toString();
        Assertions.assertEquals(r, exec(r, new Object(), Object.class).name);
    }

    @Test
    public void expectedObject() {
        String r = UUID.randomUUID().toString();
        Assertions.assertEquals(r, exec("name", r, String.class).data);
    }

    @Test
    public void expectedDataClass() {
        Assertions.assertEquals(String.class, exec("name", "data", String.class).dataClass);
    }
}
