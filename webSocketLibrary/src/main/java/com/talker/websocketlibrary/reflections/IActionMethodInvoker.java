package com.talker.websocketlibrary.reflections;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public interface IActionMethodInvoker {
    Optional<Object> invoke(Method method, Object controller, Object[] params);
}
