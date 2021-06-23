package com.talker.websocketlibrary.messaging;

import com.talker.websocketlibrary.Message;
import com.talker.websocketlibrary.MessageWithData;
import com.talker.websocketlibrary.binding.BindingResult;
import com.talker.websocketlibrary.binding.IDataBinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMessageParser implements IMessageParser {

    public IDataBinder dataBinder;

    public DefaultMessageParser(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }

    @Override
    public Message read(String text, String userId) {
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z_-]+]) (?<data>.+)$");
        Matcher match = pattern.matcher(text);
        String name = match.group("name");
        String data = match.group("data");
        return new Message(name, data, text);
    }

    @Override
    public <T> MessageWithData<T> read(String text, String userId, Class<T> dataClass) {
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z_-]+]) (?<data>.+)$");
        Matcher match = pattern.matcher(text);
        String name = match.group("name");
        String data = match.group("data");
        BindingResult<T> bind = dataBinder.bind(data, dataClass);
        return new MessageWithData<T>(name, data, text, bind.data, bind.dataClass);
    }
}
