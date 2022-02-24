package com.talker.websocketlibrary.reflections.tests;

import com.talker.websocketlibrary.reflections.NullResultInterpreter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class NullResultInterpreter_canInterpret_Tests {
    boolean exec(Optional<Object> opt) {
        return new NullResultInterpreter().canInterpret(opt);
    }

    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec(Optional.empty()));
    }

    @Test
    public void trueIfOptionalEmpty() {
        Assertions.assertTrue(exec(Optional.empty()));
    }

    @Test
    public void falseIfOptionalNotEmpty() {
        Assertions.assertFalse(exec(Optional.of(5)));
    }
}
