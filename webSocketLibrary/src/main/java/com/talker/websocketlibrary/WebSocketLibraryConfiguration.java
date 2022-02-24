package com.talker.websocketlibrary;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.talker.websocketlibrary.binding", "com.talker.websocketlibrary.commons", "com.talker.websocketlibrary.handlers", "com.talker.websocketlibrary.messaging", "com.talker.websocketlibrary.reflections", "com.talker.websocketlibrary"})
@Configuration
public class WebSocketLibraryConfiguration {
}
