package com.hbatis.v2.session;


public class SqlSessionFactoryBuild {

  private Configuration configuration;
  
  public SqlSessionFactoryBuild build() {
    configuration=new Configuration();
    return this;
  }
  public DefaultSqlSession openSqlSession(){
    return new DefaultSqlSession(configuration);
  }
}
