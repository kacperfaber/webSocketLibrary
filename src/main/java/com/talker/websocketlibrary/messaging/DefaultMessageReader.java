package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DefaultMessageReader implements IMessageReader {

    @Override
    public Message read(String text, String userId) {
        Pattern pattern = Pattern.compile("(?<name>.+) (?<data>.+)");
        Matcher match = pattern.matcher(text);
        if (match.matches()) {
            String name = match.group("name");
            String data = match.group("data");
            return new Message(name, data, text, userId);
        }
    }
}
