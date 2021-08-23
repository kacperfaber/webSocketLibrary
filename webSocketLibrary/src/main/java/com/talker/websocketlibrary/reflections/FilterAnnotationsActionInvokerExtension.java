package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.annotations.FilterClassName;
import com.talker.websocketlibrary.reflections.exceptions.ActionInvokerException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterAnnotationsActionInvokerExtension implements IActionInvokerExtension{
    ApplicationContext applicationContext;

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent) throws Exception{
        try {
            List<FilterClassName> filterClassNames = Arrays.stream(actionInvoke.getActionModel().method.getAnnotations())
                    .filter(x -> x.annotationType().isAnnotationPresent(FilterClassName.class))
                    .map(x -> x.annotationType().getAnnotation(FilterClassName.class))
                    .collect(Collectors.toList());

            for (FilterClassName filterClassName : filterClassNames) {
                for (Class<? extends IFilter> filterClass : filterClassName.value()) {
                    IFilter filter = applicationContext.getBean(filterClass);
                    filter.filter(actionInvoke, controller, handlerEvent);
                }
            }
        }
        catch (ActionInvokerException e) {
            // TODO: Do something, we have message to send, and we've to cancel processing a message.
        }
    }
}
