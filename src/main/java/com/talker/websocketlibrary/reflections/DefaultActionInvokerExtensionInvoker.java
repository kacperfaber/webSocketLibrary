package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

@Component
public class DefaultActionInvokerExtensionInvoker implements IActionInvokerExtensionInvoker{
    @Override
    public void invoke(IActionInvokerExtension extension, ActionInvoke actionInvoke, ActionModel actionModel, Command command, Object controller) {
        extension.beforeInvoke(actionInvoke, actionModel, command, controller);
    }
}
