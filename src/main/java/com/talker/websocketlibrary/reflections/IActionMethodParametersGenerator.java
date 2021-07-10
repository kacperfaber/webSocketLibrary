package com.talker.websocketlibrary.reflections;

import java.lang.reflect.Method;
import java.util.List;

public interface IActionMethodParametersGenerator {
    Object[] generate(Method actionMethod, List<InvokeParameter> invokeParameters);
}
