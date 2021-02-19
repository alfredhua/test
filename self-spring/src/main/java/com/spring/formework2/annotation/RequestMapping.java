package com.spring.formework2.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {


    String value() default "";
}
