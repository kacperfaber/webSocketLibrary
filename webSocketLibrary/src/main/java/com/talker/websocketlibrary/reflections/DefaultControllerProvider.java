package com.talker.websocketlibrary.reflections;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class DefaultControllerProvider implements IControllerProvider {
    ApplicationContext applicationContext;

    public DefaultControllerProvider(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object provide(Class<?> controllerClass) {
        return applicationContext.getBean(controllerClass);
    }
}
