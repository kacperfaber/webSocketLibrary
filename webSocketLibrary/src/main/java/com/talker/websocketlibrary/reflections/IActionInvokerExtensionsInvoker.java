package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

import java.util.List;

public interface IActionInvokerExtensionsInvoker {
    void invokeAll(List<ActionInvokerExtensionModel> extensions, ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) throws Exception;
}
