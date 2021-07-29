package com.talker.websocketlibrary.handlers;

public interface IEventHandler {
    boolean canHandle(HandlerEvent handlerEvent);
    void handle(HandlerEvent handlerEvent) throws Exception;
}
