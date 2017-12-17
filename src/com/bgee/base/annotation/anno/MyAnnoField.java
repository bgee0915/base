package com.bgee.base.annotation.anno;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnoField {
        String value() default "default value";
}
