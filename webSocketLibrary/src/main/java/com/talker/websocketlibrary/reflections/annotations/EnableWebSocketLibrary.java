package com.talker.websocketlibrary.reflections.annotations;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan({"com.talker.websocketlibrary.binding", "com.talker.websocketlibrary.commons", "com.talker.websocketlibrary.handlers", "com.talker.websocketlibrary.messaging", "com.talker.websocketlibrary.reflections", "com.talker.websocketlibrary"})
public @interface EnableWebSocketLibrary {
}
