package com.hbatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class HConfiguration {

      public static final ResourceBundle sqlMappings;

      static {
        sqlMappings=ResourceBundle.getBundle("sql");
      }

      public <T> T getMapper(Class clazz,HSqlSession sqlSession){
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},new HMapperProxy(sqlSession));
      }


}
