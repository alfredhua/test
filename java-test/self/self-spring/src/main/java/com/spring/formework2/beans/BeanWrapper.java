package com.spring.formework2.beans;

import com.spring.formework2.aop.AopConfig;
import com.spring.formework2.aop.AopProxy;
import com.spring.formework2.core.FactoryBean;

public class BeanWrapper extends FactoryBean {

  private AopProxy aopProxy = new AopProxy();

  //还会用到  观察者  模式
  //1、支持事件响应，会有一个监听
  private BeanPostProcessor postProcessor;



  private Object wrapperInstance;
  //原始的通过反射new出来，要把包装起来，存下来
  private Object originalInstance;



  public BeanWrapper(Object instance){
    //从这里开始，我们要把动态的代码添加进来了
    this.wrapperInstance = aopProxy.getProxy(instance);
    this.originalInstance = instance;
  }


  public Object getOriginalInstance() {
    return originalInstance;
  }

  public void setAopConfig(AopConfig config) {
    aopProxy.setConfig(config);
  }

  public void setPostProcessor(BeanPostProcessor postProcessor) {
    this.postProcessor = postProcessor;
  }

  public Object getWrappedInstance() {
    return wrapperInstance;
  }
}
