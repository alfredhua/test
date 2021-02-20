package com.hbatis.v1;

public class HSqlSession {

  private HConfiguration configuration;

  private HExecutor executor;

  public HSqlSession(HConfiguration configuration, HExecutor executor) {
    this.configuration = configuration;
    this.executor = executor;
  }


  public <T> T getMapper(Class t) {
    return configuration.getMapper(t,this);
  }


  public Object selectOne(String statementId, Object paramater) {
    String sql = HConfiguration.sqlMappings.getString(statementId);
    if(null != sql && !"".equals(sql)){
      return executor.query(sql, paramater );
    }
    return null;
  }

}
