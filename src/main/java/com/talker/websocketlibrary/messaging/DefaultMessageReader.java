package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.binding.IDataBinder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DefaultMessageReader implements IMessageReader {
    public IDataBinder dataBinder;

    public DefaultMessageReader(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }

    @Override
    public Message read(String text, String userId) {
        try {
            Pattern pattern = Pattern.compile("^(?<name>.+) (?<data>.+)$");
            Matcher match = pattern.matcher(text);
            String name = match.group("name");
            String data = match.group("data");
            return new Message(name, data, text, userId);
        }
        catch (Exception e) {
            return new Message("", "", "", "");
        }
    }
}
