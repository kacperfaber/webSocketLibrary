package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.util.List;
import java.util.Set;

public interface IAllClassesProvider {
    Set<Class<?>> provide();
}
