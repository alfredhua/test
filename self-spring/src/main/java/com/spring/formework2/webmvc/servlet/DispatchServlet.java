package com.spring.formework2.webmvc.servlet;

import com.spring.formework2.annotation.Controller;
import com.spring.formework2.annotation.RequestMapping;
import com.spring.formework2.annotation.RequestParam;
import com.spring.formework2.aop.AopProxyUtils;
import com.spring.formework2.context.ApplicationContext;
import com.spring.formework2.webmvc.HandlerAdapter;
import com.spring.formework2.webmvc.HandlerMapping;
import com.spring.formework2.webmvc.ModelAndView;
import com.spring.formework2.webmvc.ViewResolver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DispatchServlet extends HttpServlet {


  private final String LOCATION="contextConfigLocation";

  //课后再去思考一下这样设计的经典之处
  //GPHandlerMapping最核心的设计，也是最经典的
  //它牛B到直接干掉了Struts、Webwork等MVC框架
  private List<HandlerMapping> handlerMappings = new ArrayList<>();


  private Map<HandlerMapping, HandlerAdapter> handlerAdapters = new HashMap<>();


  private List<ViewResolver> viewResolvers = new ArrayList<>();




  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      doDispatch(req, resp);
    }catch (Exception e){
      resp.getWriter().write("<font size='25' color='blue'>500 Exception</font><br/>Details:<br/>"
                                 + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","") .replaceAll("\\s","\r\n")
                                 +  "<font color='green'><i>Copyright@GupaoEDU</i></font>");
      e.printStackTrace();
    }
  }

  private void doDispatch(HttpServletRequest req, HttpServletResponse resp)throws Exception {

    HandlerMapping handler=getHandler(req);

    HandlerAdapter ha = getHandlerAdapter(handler);

    ModelAndView mv = ha.handle(req, resp, handler);
    //这一步才是真的输出
    processDispatchResult(resp, mv);

  }


  private HandlerAdapter getHandlerAdapter(HandlerMapping handler) {
    if(this.handlerAdapters.isEmpty()){
      return null;
    }
    return this.handlerAdapters.get(handler);
  }


  private void processDispatchResult(HttpServletResponse resp, ModelAndView mv) throws Exception {
    //调用viewResolver的resolveView方法
    if(null == mv){ return;}

    if(this.viewResolvers.isEmpty()){ return;}

    for (ViewResolver viewResolver: this.viewResolvers) {
      if(!mv.getViewName().equals(viewResolver.getViewName())){ continue; }
      String out = viewResolver.viewResolver(mv);
      if(out != null){
        resp.getWriter().write(out);
        break;
      }
    }
  }





  private HandlerMapping getHandler(HttpServletRequest req) {
    if(this.handlerMappings.isEmpty()){
      return null;
    }
    String url = req.getRequestURI();
    String contextPath = req.getContextPath();

    url=url.replace(contextPath,"").replaceAll("/+","/");

    for (HandlerMapping handler:this.handlerMappings){
      Matcher  matcher=handler.getPattern().matcher(url);
      if(!matcher.matches()){
        continue;
      }
      return handler;
    }
    return null;
  }

  @Override
  public void init(ServletConfig config) throws ServletException {

    ApplicationContext context=new ApplicationContext(config.getInitParameter(LOCATION));
    initStrategies(context);
  }

  //初始化9大组件
  protected void initStrategies(ApplicationContext context) {
    //文件上传下载
    initMultipartResolver(context);
    //本地化解析
    initLocaleResolver(context);
    //主题
    initThemeResolver(context);


    //controller与mappering的对应关系
    initHandlerMappings(context);
    //动态匹配handlerAdapter
    initHandlerAdapters(context);


    //遇到异常时候的处理
    initHandlerExceptionResolvers(context);
    //直接解析请求到视图名
    initRequestToViewNameTranslator(context);



    //视图解析
    initViewResolvers(context);



    //flash映射管理器
    initFlashMapManager(context);
  }

  //将Controller中配置的RequestMapping和Method进行一一对应
  private void initHandlerMappings(ApplicationContext context) {
    String [] beanNames = context.getBeanDefinitionNames();
    try {
      for (String beanName : beanNames) {
        Object proxy = context.getBean(beanName);
        //匹配Controller中的方法进行调用
        Object controller = AopProxyUtils.getTargetObject(proxy);

        Class<?> clazz = controller.getClass();
        if(!clazz.isAnnotationPresent(Controller.class)){
          continue;
        }

        String baseUrl = "" ;

        if (clazz.isAnnotationPresent(RequestMapping.class)){
          RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
          baseUrl=requestMapping.value();
        }

        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
          if (!method.isAnnotationPresent(RequestMapping.class)) {
            continue;
          }
          RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
          String regex = ("/" +baseUrl+ requestMapping.value().replaceAll("\\*", ".*")).replaceAll("/+", "/");
          Pattern pattern = Pattern.compile(regex);
          this.handlerMappings.add(new HandlerMapping(pattern, controller, method));
          System.out.println("Mapping: " + regex + " , " + method);
        }

      }
    }catch (Exception e){
      e.printStackTrace();
    }


  }

  private void initHandlerAdapters(ApplicationContext context) {
    //在初始化阶段，我们能做的就是，将这些参数的名字或者类型按一定的顺序保存下来
    //因为后面用反射调用的时候，传的形参是一个数组
    //可以通过记录这些参数的位置index,挨个从数组中填值，这样的话，就和参数的顺序无关了
    for (HandlerMapping handlerMapping:this.handlerMappings) {

      Map<String,Integer> paramMapping=new HashMap<>();

      Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
      for (int i = 0; i < pa.length ; i ++) {
        for (Annotation a : pa[i]) {
          if(a instanceof RequestParam){
            String paramName = ((RequestParam) a).value();
            if(!"".equals(paramName.trim())){
              paramMapping.put(paramName,i);
            }
          }
        }
      }

      //接下来，我们处理非命名参数
      //只处理Request和Response
      Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
      for (int i = 0;i < paramTypes.length; i ++) {
        Class<?> type = paramTypes[i];
        if(type == HttpServletRequest.class ||
               type == HttpServletResponse.class){
          paramMapping.put(type.getName(),i);
        }
      }

      this.handlerAdapters.put(handlerMapping,new HandlerAdapter(paramMapping));

    }

  }

  private void initViewResolvers(ApplicationContext context) {
    String templateRoot = context.getConfig().getProperty("templateRoot");
    String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

    File templateRootDir = new File(templateRootPath);

    for (File template : templateRootDir.listFiles()) {
      this.viewResolvers.add(new ViewResolver(template.getName(),template));
    }

  }













  private void initFlashMapManager(ApplicationContext context) {

  }


  private void initRequestToViewNameTranslator(ApplicationContext context) {

  }

  private void initHandlerExceptionResolvers(ApplicationContext context) {

  }

  private void initThemeResolver(ApplicationContext context) {
  }

  private void initLocaleResolver(ApplicationContext context) {
  }

  private void initMultipartResolver(ApplicationContext context) {
  }

}
