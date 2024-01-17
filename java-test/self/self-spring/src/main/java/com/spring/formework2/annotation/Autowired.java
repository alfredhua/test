package com.spring.formework2.annotation;


import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {


    String value() default "";


}
