package com.talker.websocketlibrary.reflections;

public class CommandWithData<T> extends Command {
    final T data;
    final Class<T> dataClass;

    public CommandWithData(String name, String rawText, String dataText, String userId, String sessionId, T data, Class<T> dataClass) {
        super(name, rawText, dataText, userId, sessionId);
        this.data = data;
        this.dataClass = dataClass;
    }

    public T getData() {
        return data;
    }

    public Class<T> getDataClass() {
        return dataClass;
    }
}
