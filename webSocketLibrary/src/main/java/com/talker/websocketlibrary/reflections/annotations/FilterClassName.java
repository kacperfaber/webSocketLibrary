package com.talker.websocketlibrary.reflections.annotations;

import com.talker.websocketlibrary.reflections.IFilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface FilterClassName {
    Class<? extends IFilter>[] value();
}
