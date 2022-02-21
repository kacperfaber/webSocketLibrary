package com.talker.websocketlibrary.tests;

import com.talker.websocketlibrary.ControllerBase;
import com.talker.websocketlibrary.reflections.ResponseResult;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

public class ControllerBase_responseResult_Tests {
    class Controller extends ControllerBase {
    }

    <T> ResponseResult exec(String name, T data, Class<T> dataClass) {
        return new Controller().responseResult(name, data, dataClass);
    }

    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec("hello", 50, int.class));
    }

    @Test
    public void notNull() {
        Assertions.assertNotNull(exec("hello", 50, int.class));
    }

    @Test
    public void expectedName() {
        String str = UUID.randomUUID().toString();
        Assertions.assertEquals(str, exec(str, 50, int.class).name);
    }

    @Test
    public void expectedData() {
        String str = UUID.randomUUID().toString();
        Assertions.assertEquals(str, exec("name", str, String.class).data);
    }

    @Test
    public void expectedDataClass() {
        Assertions.assertEquals(int.class, exec("name", null, int.class).dataClass);
    }
}
