package com.talker.websocketlibrary.handlers;

public interface IEventHandler {
    boolean canHandle(HandlerEventKind handlerEventKind);
    void handle(HandlerEvent handlerEvent);
}
