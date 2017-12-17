package com.bgee.base.annotation.anno;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.TYPE, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String color() default "black";
    String name() default "nameless";
    String value() default "none";
}


