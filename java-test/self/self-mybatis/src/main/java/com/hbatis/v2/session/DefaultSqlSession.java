package com.hbatis.v2.session;

import com.hbatis.v2.executor.Executor;

public class DefaultSqlSession {

  private Configuration configuration;

  private Executor executor;


  public DefaultSqlSession(Configuration configuration) {

    this.configuration = configuration;
    this.executor=configuration.newExecutor();

  }


  public <T> T getMapper(Class clazz) {
    return configuration.getMapper(clazz,this);
  }


}
