package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.binding.IDataBinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMessageReader implements IMessageReader {

    public IDataBinder dataBinder;

    public DefaultMessageReader(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }

    @Override
    public Message read(String text, String userId) {
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z_-]+) (?<data>.+)$");
        Matcher match = pattern.matcher(text);
        String name = match.group("name");
        String data = match.group("data");
        return new Message(name, data, text, userId);
    }
}
