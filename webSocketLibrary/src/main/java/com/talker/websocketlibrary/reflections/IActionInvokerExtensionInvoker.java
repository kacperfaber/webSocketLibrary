package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IActionInvokerExtensionInvoker {
    void invoke(IActionInvokerExtension extension, ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent);
}
