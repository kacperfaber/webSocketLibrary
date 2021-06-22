package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;

import java.util.List;
import java.util.Set;

public interface IControllerClassesProvider {
    Set<Class<? extends ControllerBase>> provide();
}
