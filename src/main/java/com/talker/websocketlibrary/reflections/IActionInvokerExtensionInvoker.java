package com.talker.websocketlibrary.reflections;

public interface IActionInvokerExtensionInvoker {
    void invoke(IActionInvokerExtension extension, ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller);
}
