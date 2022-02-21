package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.MessageService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ResponseResultInterpreter implements IResultInterpreter{
    public MessageService messageService;

    public ResponseResultInterpreter(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public boolean canInterpret(Optional<Object> methodInvokerResult) {
        return methodInvokerResult.filter(o -> o.getClass() == ResponseResult.class).isPresent();
    }

    @Override
    public void interpret(Optional<Object> methodInvokerResult, Command command) throws IOException {
        ResponseResult response = (ResponseResult) methodInvokerResult.get();
        messageService.sendToSession(command.getSessionId(), response.name, response.data, (Class<? super Object>) response.dataClass);
    }
}
