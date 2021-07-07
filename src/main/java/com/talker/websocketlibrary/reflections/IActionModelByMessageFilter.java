package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;

import java.util.List;

public interface IActionModelByMessageFilter {
    List<ActionModel> filter(List<ActionModel> actionModels, Message message);
}
