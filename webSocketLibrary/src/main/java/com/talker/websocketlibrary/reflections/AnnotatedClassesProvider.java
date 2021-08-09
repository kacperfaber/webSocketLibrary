package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.reflections.annotations.SocketController;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AnnotatedClassesProvider implements IAnnotatedClassesProvider {
    @Override
    public Set<Class<?>> provide(String prefix) {
        Reflections reflections = new Reflections(prefix,new TypeAnnotationsScanner(), new SubTypesScanner());
        return reflections.getTypesAnnotatedWith(SocketController.class);
    }
}
