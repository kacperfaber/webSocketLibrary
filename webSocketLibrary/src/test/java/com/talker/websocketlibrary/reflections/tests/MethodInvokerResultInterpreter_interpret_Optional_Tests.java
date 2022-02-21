package com.talker.websocketlibrary.reflections.tests;

import com.talker.websocketlibrary.reflections.IResultInterpreter;
import com.talker.websocketlibrary.reflections.MethodInvokerResultInterpreter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MethodInvokerResultInterpreter_interpret_Optional_Tests {
    void exec(Optional<Object> opt, List<IResultInterpreter> list) throws Exception {
        new MethodInvokerResultInterpreter(list).interpret(opt, null);
    }
    @Test
    public void doesNotThrow() {
        IResultInterpreter mock = mock(IResultInterpreter.class);
        when(mock.canInterpret(any())).thenReturn(true);
        ArrayList<IResultInterpreter> list = new ArrayList<>() {{add(mock);}};
        Assertions.assertDoesNotThrow(() -> exec(Optional.empty(), list));
    }
    @Test
    public void asksCanInterpretMethodOfEachListElement() throws Exception {
        IResultInterpreter mock1 = mock(IResultInterpreter.class);
        when(mock1.canInterpret(any())).thenReturn(true);
        IResultInterpreter mock2 = mock(IResultInterpreter.class);
        when(mock2.canInterpret(any())).thenReturn(true);
        ArrayList<IResultInterpreter> list = new ArrayList<>() {{add(mock1); add(mock2);}};
        exec(Optional.empty(), list);
        verify(mock1, times(1)).canInterpret(any());
        verify(mock2, times(1)).canInterpret(any());
    }

    // TODO: finish it.
}
