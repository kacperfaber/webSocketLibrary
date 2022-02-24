package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DefaultActionInvokeGenerator implements IActionInvokeGenerator {
    @Override
    public ActionInvoke generate(ActionModel actionModel, Command command) {
        return new ActionInvoke(new ArrayList<>(), actionModel, command);
    }
}
