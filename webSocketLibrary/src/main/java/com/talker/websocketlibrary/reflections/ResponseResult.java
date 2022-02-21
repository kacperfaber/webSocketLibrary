package com.talker.websocketlibrary.reflections;

public class ResponseResult extends ActionResult {
    public ResponseResult(String name, Object data, Class<Object> dataClass) {
        super(name, data, dataClass);
    }
}
