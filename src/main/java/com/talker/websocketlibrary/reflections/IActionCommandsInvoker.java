package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;

public interface IActionCommandsInvoker {
    void invokeAll(Model model, Message message);
}
