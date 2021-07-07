package com.talker.websocketlibrary.messaging;

import com.google.gson.Gson;
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
        // TODO: Parsing message with format "<name> <data>" throws an exception, that closing an connection with status code 1011.
        throw new UnsupportedOperationException();
    }
}
