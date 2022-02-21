package com.talker.websocketlibrary.reflections.tests;

import com.talker.websocketlibrary.reflections.NullResultInterpreter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class NullResultInterpret_interpret_Tests {
    void exec(Optional<Object> opt) {
        new NullResultInterpreter().interpret(opt, null);
    }
    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec(Optional.empty()));
    }
}
