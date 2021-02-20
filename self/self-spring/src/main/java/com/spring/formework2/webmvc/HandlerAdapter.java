package com.spring.formework2.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

public class HandlerAdapter {

  private Map<String,Integer> paramMapping;

  public HandlerAdapter(Map<String,Integer> paramMapping){
    this.paramMapping = paramMapping;
  }


  public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, HandlerMapping handler)  throws  Exception  {

    Class<?>[] paramTypes = handler.getMethod().getParameterTypes();

    Map<String,String[]>  parameterMap = req.getParameterMap();

    Object [] paramValues = new Object[paramTypes.length];
    for (Map.Entry<String,String[]> param :parameterMap.entrySet()) {
      String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]","").replaceAll("\\s","");

      if(!this.paramMapping.containsKey(param.getKey())){continue;}
      int index = this.paramMapping.get(param.getKey());

      //因为页面上传过来的值都是String类型的，而在方法中定义的类型是千变万化的
      //要针对我们传过来的参数进行类型转换
      paramValues[index] = caseStringValue(value,paramTypes[index]);

      if(this.paramMapping.containsKey(HttpServletRequest.class.getName())) {
        int reqIndex = this.paramMapping.get(HttpServletRequest.class.getName());
        paramValues[reqIndex] = req;
      }

      if(this.paramMapping.containsKey(HttpServletResponse.class.getName())) {
        int respIndex = this.paramMapping.get(HttpServletResponse.class.getName());
        paramValues[respIndex] = resp;
      }

      Object result = handler.getMethod().invoke(handler.getController(),paramValues);

      if(result == null){ return  null; }

      boolean isModelAndView = handler.getMethod().getReturnType() == ModelAndView.class;
      if(isModelAndView){
        return (ModelAndView)result;
      }else{
        return null;
      }
    }
    return null;
  }


  private Object caseStringValue(String value,Class<?> clazz){
    if(clazz == String.class){
      return value;
    }else if(clazz == Integer.class){
      return  Integer.valueOf(value);
    }else if(clazz == int.class){
      return Integer.valueOf(value).intValue();
    }else {
      return null;
    }
  }




}
