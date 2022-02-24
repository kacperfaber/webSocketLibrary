package com.talker.websocketlibrary.tests;

import com.talker.websocketlibrary.ControllerBase;
import com.talker.websocketlibrary.reflections.ResponseResult;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

public class ControllerBase_emptyResponse_Tests {
    ResponseResult exec(String name) {
        return new Controller().emptyResponse(name);
    }

    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec("name"));
    }

    @Test
    public void notNull() {
        Assertions.assertNotNull(exec("name"));
    }

    @Test
    public void expectedName() {
        String s = UUID.randomUUID().toString();
        Assertions.assertEquals(s, exec(s).name);
    }

    @Test
    public void notNullData() {
        Assertions.assertNotNull(exec("name").data);
    }

    @Test
    public void dataIsObject() {
        Assertions.assertEquals(Object.class, exec("name").data.getClass());
    }

    @Test
    public void dataClassIsObject() {
        Assertions.assertEquals(Object.class, exec("name").dataClass);
    }

    class Controller extends ControllerBase {
    }
}
