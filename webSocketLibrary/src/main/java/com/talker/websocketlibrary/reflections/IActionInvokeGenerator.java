package com.talker.websocketlibrary.reflections;

public interface IActionInvokeGenerator {
    ActionInvoke generate(ActionModel actionModel, Command command);
}
