package com.spring.formework2.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class AopProxyUtils {


  public static Object getTargetObject(Object proxy) throws Exception{

    if (!isAopProxy(proxy)){
      return proxy;
    }
    return getProxyTargetObject(proxy);
  }

  private static Object getProxyTargetObject(Object proxy) throws Exception {
    Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
    h.setAccessible(true);
    AopProxy  aopProxy =(AopProxy) h.get(proxy);
    Field target = aopProxy.getClass().getDeclaredField("target");
    target.setAccessible(true);
    return target.get(aopProxy);
  }

  private static boolean isAopProxy(Object object){
    return Proxy.isProxyClass(object.getClass());
  }


}
