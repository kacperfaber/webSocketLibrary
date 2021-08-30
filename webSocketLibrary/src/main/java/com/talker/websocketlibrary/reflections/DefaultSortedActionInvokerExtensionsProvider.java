package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.ActionInvokerExtension;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultSortedActionInvokerExtensionsProvider implements ISortedActionInvokerExtensionsProvider {
    List<IActionInvokerExtension> extensions;

    public DefaultSortedActionInvokerExtensionsProvider(List<IActionInvokerExtension> extensions) {
        this.extensions = extensions;
    }

    @Override
    public List<ActionInvokerExtensionModel> provide() {
        return extensions
                .stream()
                .map(x -> new ActionInvokerExtensionModel(x, x.getClass().getAnnotation(ActionInvokerExtension.class)))
                .sorted((o1, o2) -> o1.annotation.weight())
                .collect(Collectors.toList());
    }
}
