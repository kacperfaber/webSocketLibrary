package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.MessageService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class BroadcastResultInterpreter implements IResultInterpreter {
    public final MessageService messageService;

    public BroadcastResultInterpreter(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public boolean canInterpret(Optional<Object> methodInvokerResult) {
        return methodInvokerResult.filter(o -> o.getClass() == BroadcastResult.class).isPresent();
    }

    @Override
    public void interpret(Optional<Object> methodInvokerResult, Command command) throws IOException {
        BroadcastResult result = (BroadcastResult) methodInvokerResult.get();
    }
}
