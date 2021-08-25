package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultExceptionHandler implements IExceptionHandler {
    List<IExceptionHandlerExtension> extensions;

    public DefaultExceptionHandler(List<IExceptionHandlerExtension> extensions) {
        this.extensions = extensions;
    }

    @Override
    public void handle(Exception exception, ActionInvoke actionInvoke, HandlerEvent handlerEvent) {
        for (IExceptionHandlerExtension ext : extensions) {
            ext.handle(handlerEvent, actionInvoke, exception);
        }
    }
}
