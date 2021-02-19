package com.spring.formework2.context.support;

import com.spring.formework2.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BeanDefinitionReader {

  private Properties config = new Properties();

  private final String SCAN_PACKAGE = "scanPackage";

  List<String> registerBeanClasses=new ArrayList<>();

  public BeanDefinitionReader(String...locations) {
    InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
    try {
      config.load(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    doScanner(config.getProperty(SCAN_PACKAGE));
  }

  public List<String> loadBeanDefinitions(){
    return this.registerBeanClasses;
  }

  public Properties getConfig(){
    return this.config;
  }

  //扫描class文件
  private void doScanner(String packageName) {
    URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
    File scanFile=new File(url.getFile());
    File[] files = scanFile.listFiles();
    for (File file:files) {
      if(file.isDirectory()){
          doScanner(packageName+"."+file.getName());
      }else{
        registerBeanClasses.add(packageName+"."+file.getName().replace(".class",""));
      }
    }
  }

  public BeanDefinition registerBean(String beanName) {

    if(this.registerBeanClasses.contains(beanName)){
      BeanDefinition beanDefinition = new BeanDefinition();
      beanDefinition.setBeanClassName(beanName);
      beanDefinition.setFactoryBeanName(lowerFirstCase(beanName.substring(beanName.lastIndexOf(".")+1)));
      return beanDefinition;
    }
      return null;
  }

  private String lowerFirstCase(String str){
    char [] chars = str.toCharArray();
    chars[0] += 32;
    return String.valueOf(chars);
  }
}
