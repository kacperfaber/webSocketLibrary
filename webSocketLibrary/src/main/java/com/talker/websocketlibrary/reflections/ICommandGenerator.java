package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.handlers.HandlerEvent;
import com.talker.websocketlibrary.messaging.Message;

public interface ICommandGenerator {
    Command generate(Message message, HandlerEvent handlerEvent);
}
