package com.hbatis.v2.binding;

import com.hbatis.v2.session.DefaultSqlSession;

import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {

    private Class<T> mapperInterface;

    private Class object;


    public T newInstance(DefaultSqlSession sqlSession){
      return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},new MapperProxy(sqlSession,object));
    }

}
