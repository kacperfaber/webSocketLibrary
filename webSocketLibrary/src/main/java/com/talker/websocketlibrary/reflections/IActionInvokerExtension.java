package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IActionInvokerExtension {
    void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent) throws Exception;
}
