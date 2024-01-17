package com.spring.formework2.beans;

public class BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    return bean;
  }
  public Object postProcessAfterInitialization(Object bean, String beanName){
    return bean;
  }


}
