package com.talker.websocketlibrary.reflections;

import java.util.Set;

public interface IAnnotatedClassesProvider {
    Set<Class<?>> provide();
}
