package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.ControllerBase;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;

public class ControllerClassesProvider implements IControllerClassesProvider{
    @Override
    public Set<Class<? extends ControllerBase>> provide() {
        Reflections reflections = new Reflections("com.talker", new SubTypesScanner());
        return reflections.getSubTypesOf(ControllerBase.class);
    }
}
