package com.talker.websocketlibrary.reflections;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class DefaultActionInvoker implements IActionInvoker {
    @Override
    public void invoke(ActionModel actionModel, Object controller, Command command) throws InvocationTargetException, IllegalAccessException {
        actionModel.method.invoke(controller, command);
    }
}
