package com.talker.websocketlibrary.reflections;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    public String value() default "";
}
