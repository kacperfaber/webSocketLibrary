package com.talker.websocketlibrary.reflections;

import java.util.List;
import java.util.Optional;

public interface IActionMethodInvoker {
    Optional<Object> invoke(ActionInvoke actionInvoke);
}
