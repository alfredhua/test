package com.hbatis.v2.binding;

import com.hbatis.v2.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

  private DefaultSqlSession sqlSession;

  private Class object;

  public MapperProxy(DefaultSqlSession sqlSession,Class object){

    this.sqlSession=sqlSession;
    this.object=object;

  }


  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return null;
  }


}
