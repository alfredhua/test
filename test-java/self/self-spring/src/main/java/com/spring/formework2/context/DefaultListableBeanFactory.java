package com.spring.formework2.context;

import com.spring.formework2.beans.BeanDefinition;

import java.util.HashMap;
import java.util.Map;


class DefaultListableBeanFactory extends AbstractApplicationContext {

  Map<String, BeanDefinition> beanDefinitionMap=new HashMap<>();


}
