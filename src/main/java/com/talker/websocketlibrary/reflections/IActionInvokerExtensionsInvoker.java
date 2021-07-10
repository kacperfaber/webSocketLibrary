package com.talker.websocketlibrary.reflections;

import java.util.List;

public interface IActionInvokerExtensionsInvoker {
    void invokeAll(List<IActionInvokerExtension> extensions, ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller);
}
