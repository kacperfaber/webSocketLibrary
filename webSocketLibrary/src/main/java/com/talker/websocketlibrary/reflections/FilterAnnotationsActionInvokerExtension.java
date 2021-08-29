package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.reflections.annotations.FilterClassName;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterAnnotationsActionInvokerExtension implements IActionInvokerExtension{
    ApplicationContext applicationContext;

    public FilterAnnotationsActionInvokerExtension(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) throws Exception{
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
}
