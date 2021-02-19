package com.hbatis.v2.session;

import com.hbatis.v2.binding.MapperRegistry;
import com.hbatis.v2.executor.Executor;
import com.hbatis.v2.executor.SimpleExecutor;

import java.io.File;
import java.util.*;

public class Configuration {

  public static final ResourceBundle sqlMappings; // SQL映射关系配置，使用注解时不用重复配置

  public static final ResourceBundle properties; // 全局配置

  public static final MapperRegistry MAPPER_REGISTRY = new MapperRegistry(); // 维护接口与工厂类关系
  public static final Map<String, String> mappedStatements = new HashMap<>();
  private List<Class<?>> mapperList = new ArrayList<>(); // 所有Mapper接口
  private List<String> classPaths = new ArrayList<>(); // 类所有文件

  static {
    sqlMappings=ResourceBundle.getBundle("sql");
    properties=ResourceBundle.getBundle("mybatis");

  }


  public Configuration(){
    // 1.解析sql.properties
    for (String key:sqlMappings.keySet()) {
      Class mapper=null;
      Class pojo=null;
      String statement= sqlMappings.getString(key).split("--")[0];
      String pojoStr = sqlMappings.getString(key).split("--")[1];

      try {

        Class.forName(key.substring(0, key.lastIndexOf(".")));
        pojo=Class.forName(pojoStr);

      }catch (Exception e){
        e.printStackTrace();
      }

      MAPPER_REGISTRY.addMapper(mapper,pojo);
      mappedStatements.put(key,statement);

    }

    String mapperPath = properties.getString("mapper.path");
    scanPackage(mapperPath);


  }

  private void scanPackage(String mapperPath) {
    String classPath = this.getClass().getResource("/").getPath();
    mapperPath = mapperPath.replace(".", File.separator);
    String mainPath = classPath + mapperPath;

    doPath(new File(mainPath));

    for (String className : classPaths) {

      className = className.replace(classPath.replace("/","\\").replaceFirst("\\\\",""),"").replace("\\",".").replace(".class","");
      Class<?> clazz = null;
      try {
        clazz = Class.forName(className);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      if(clazz.isInterface()){
        mapperList.add(clazz);
      }

    }

  }

  private void doPath(File file) {
    if(file.isDirectory()){
      File[] files = file.listFiles();
      for (File f1:files) {
        doPath(f1);
      }
    }else{
      if(file.getName().endsWith(".class")){
        classPaths.add(file.getPath());
      }
    }
  }


  public Executor newExecutor() {
    Executor executor=null;
    //    if(properties.getString("cache.enabled").equals("true")){

    //    }else{
    executor=new SimpleExecutor();
    //    }
    return executor;
  }


  public <T> T getMapper(Class clazz, DefaultSqlSession sqlSession) {
    return null;
  }

}
