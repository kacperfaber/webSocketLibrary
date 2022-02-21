package com.talker.websocketlibrary.reflections;

public class ActionResult {
    public String name;
    public Object data;
    public Class<?> dataClass;

    public ActionResult(String name, Object data, Class<?> dataClass) {
        this.name = name;
        this.data = data;
        this.dataClass = dataClass;
    }
}
