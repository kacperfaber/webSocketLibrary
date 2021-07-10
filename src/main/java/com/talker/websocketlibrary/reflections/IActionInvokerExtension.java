package com.talker.websocketlibrary.reflections;

public interface IActionInvokerExtension {
    void beforeInvoke(ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller);
}
