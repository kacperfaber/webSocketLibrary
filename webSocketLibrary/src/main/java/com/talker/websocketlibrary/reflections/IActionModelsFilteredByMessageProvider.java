package com.talker.websocketlibrary.reflections;

import com.talker.websocketlibrary.messaging.Message;

import java.util.List;

public interface IActionModelsFilteredByMessageProvider {
    List<ActionModel> provide(Model model, Message message);
}
