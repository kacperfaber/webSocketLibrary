package com.talker.websocketlibrary.messaging;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DefaultMessageReader implements IMessageReader {

    @Override
    public MessagePrototype read(String text) throws Exception {
        Pattern pattern = Pattern.compile("(?<name>.+) (?<data>.+)");
        Matcher match = pattern.matcher(text);
        if (match.matches()) {
            String name = match.group("name");
            String data = match.group("data");
            return new MessagePrototype(name, data, text);
        }
        throw new Exception("Could not read the message.");
    }
}
