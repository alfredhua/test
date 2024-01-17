package com.hbatis.v2.binding;

import com.hbatis.v2.session.DefaultSqlSession;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {


  private final Map<Class<?>,MapperProxyFactory> knownMappers =new HashMap<>();


  public <T> void addMapper(Class<T> clazz,Class pojo){
    knownMappers.put(clazz,new MapperProxyFactory());
  }

  public <T> T getMapper(Class<T> clazz, DefaultSqlSession sqlSession){
    MapperProxyFactory mapperProxyFactory = knownMappers.get(clazz);
    return (T)mapperProxyFactory.newInstance(sqlSession);
  }

}
