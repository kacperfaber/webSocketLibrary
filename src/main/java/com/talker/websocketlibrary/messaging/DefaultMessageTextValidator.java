package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class DefaultMessageTextValidator implements IMessageTextValidator{
    @Override
    public boolean validate(String text) {
        return Pattern.compile("^.+ .+$").matcher(text).matches();
    }
}
