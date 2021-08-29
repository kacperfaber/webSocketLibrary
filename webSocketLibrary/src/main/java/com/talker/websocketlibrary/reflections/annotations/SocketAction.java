package com.talker.websocketlibrary.reflections.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SocketAction {
    String value() default "";
    Class<?> payloadClass();
}
