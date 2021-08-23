package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;

public interface IFilter {
    void filter(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent) throws Exception;
}
