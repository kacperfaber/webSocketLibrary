package com.talker.websocketlibrary.reflections;

public class ActionResult {
    public String name;
    public Object data;
    public Class<Object> dataClass;

    public ActionResult(String name, Object data, Class<Object> dataClass) {
        this.name = name;
        this.data = data;
        this.dataClass = dataClass;
    }
}
