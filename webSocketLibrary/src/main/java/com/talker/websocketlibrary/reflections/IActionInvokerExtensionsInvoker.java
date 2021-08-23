package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

import java.util.List;

public interface IActionInvokerExtensionsInvoker {
    void invokeAll(List<IActionInvokerExtension> extensions, ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent);
}
