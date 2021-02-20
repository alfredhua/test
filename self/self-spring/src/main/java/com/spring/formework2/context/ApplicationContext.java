package com.spring.formework2.context;


import com.spring.formework2.annotation.Autowired;
import com.spring.formework2.annotation.Controller;
import com.spring.formework2.annotation.Service;
import com.spring.formework2.aop.AopConfig;
import com.spring.formework2.beans.BeanDefinition;
import com.spring.formework2.beans.BeanPostProcessor;
import com.spring.formework2.beans.BeanWrapper;
import com.spring.formework2.context.support.BeanDefinitionReader;
import com.spring.formework2.core.BeanFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationContext extends  DefaultListableBeanFactory implements BeanFactory {

  private String[] configLocation;

  private BeanDefinitionReader reader;

  //用来存储所有的被代理过的对象
  private Map<String, BeanWrapper> beanWrapperMap = new ConcurrentHashMap<>();

  private Map<String,Object> beanCacheMap = new HashMap<String, Object>();

  public ApplicationContext(String ... configLocation) {
    this.configLocation = configLocation;
    refresh();
  }

  public void  refresh(){

    //定位
    this.reader = new BeanDefinitionReader(configLocation);

    //加载
    List<String> beanDefinitions = reader.loadBeanDefinitions();

    //注册
    doRegister(beanDefinitions);

    //加载
    doAutowrited();

  }

  private void doRegister(List<String> beanDefinitions) {
    try {
      for (String beanName : beanDefinitions) {
        Class<?> beanClass = Class.forName(beanName);
        if(beanClass.isInterface()){
          continue;
        }
        BeanDefinition beanDefinition= this.reader.registerBean(beanName);
        this.beanDefinitionMap.put(beanName, beanDefinition);
        Class<?>[] interfaces = beanClass.getInterfaces();
        for (Class clazz:interfaces ) {
          this.beanDefinitionMap.put(clazz.getName(),beanDefinition);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private void doAutowrited() {
    for (Map.Entry<String, BeanDefinition> beanDefinitionEntry: this.beanDefinitionMap.entrySet()) {
      String beanName = beanDefinitionEntry.getKey();
      if(!beanDefinitionEntry.getValue().isLazyInit()){
        Object obj=getBean(beanName);
      }
    }

    for (Map.Entry<String,BeanWrapper> beanWrapperEntry :this.beanWrapperMap.entrySet()) {
      populateBean(beanWrapperEntry.getKey(),beanWrapperEntry.getValue().getOriginalInstance());
    }
  }

  private void populateBean(String beanName, Object instance) {

    Class<?> aClass = instance.getClass();
    if(!(aClass.isAnnotationPresent(Controller.class) ||
             aClass.isAnnotationPresent(Service.class))){
      return;
    }
    Field[] fields = aClass.getDeclaredFields();

    for (Field field:fields) {
      if(!field.isAnnotationPresent(Autowired.class)){
        continue;
      }
      Autowired autowired = field.getAnnotation(Autowired.class);
      String autowiredBeanName = autowired.value().trim();
      if ("".equals(autowiredBeanName)){
        autowiredBeanName = field.getType().getName();
      }
      field.setAccessible(true);
      try {
        field.set(instance,this.beanWrapperMap.get(autowiredBeanName).getWrappedInstance());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }



  @Override
  public Object getBean(String beanName) {
    BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);

    BeanPostProcessor beanPostProcessor=new BeanPostProcessor();

    Object instance=instantionBean(beanDefinition);
    if(null == instance){ return  null;}

    //在实例初始化以前调用一次
    beanPostProcessor.postProcessBeforeInitialization(instance,beanName);

    //AOP代理
    BeanWrapper beanWrapper = new BeanWrapper(instance);
    try {
      beanWrapper.setAopConfig(instantionAopConfig(beanDefinition));
    } catch (Exception e) {
      e.printStackTrace();
    }
    beanWrapper.setPostProcessor(beanPostProcessor);
    this.beanWrapperMap.put(beanName,beanWrapper);
    //在实例初始化以后调用一次
    beanPostProcessor.postProcessAfterInitialization(instance,beanName);

    return this.beanWrapperMap.get(beanName).getWrappedInstance();

  }

  private AopConfig instantionAopConfig(BeanDefinition beanDefinition) throws Exception {
    AopConfig aopConfig=new AopConfig();
    String expression = reader.getConfig().getProperty("pointCut");
    String[] before = reader.getConfig().getProperty("aspectBefore").split("\\s");
    String[] after = reader.getConfig().getProperty("aspectAfter").split("\\s");

    String beanClassName = beanDefinition.getBeanClassName();

    Class<?> aClass = Class.forName(beanClassName);

    Pattern pattern = Pattern.compile(expression);

    Class aspectClass = Class.forName(before[0]);

    for (Method m:aClass.getMethods()){
      Matcher matcher = pattern.matcher(m.toString());
      if (matcher.matches()){
        aopConfig.put(m,aspectClass.newInstance(),new Method[]{aspectClass.getMethod(before[1]),aspectClass.getMethod(after[1])});
      }

    }
    return aopConfig;
  }


  private Object instantionBean(BeanDefinition beanDefinition) {
    Object instance = null;
    String className = beanDefinition.getBeanClassName();
    try {
      if (this.beanCacheMap.containsKey(className)) {
        instance = this.beanCacheMap.get(className);
      } else {
        Class<?> clazz = Class.forName(className);
        instance = clazz.newInstance();
        this.beanCacheMap.put(className, instance);
      }
      return instance;
    }catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public String[] getBeanDefinitionNames() {
    return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
  }



  public Properties getConfig(){
    return this.reader.getConfig();
  }



}
