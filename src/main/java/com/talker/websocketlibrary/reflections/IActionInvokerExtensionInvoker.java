package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IActionInvokerExtensionInvoker {
    void invoke(IActionInvokerExtension extension, ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller, HandlerEvent handlerEvent);
}
