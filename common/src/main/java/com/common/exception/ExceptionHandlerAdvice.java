package com.common.exception;

import com.common.domain.constants.SysErrorCodeEnum;
import com.common.mail.MailProperties;
import com.common.mail.MailUtils;
import com.common.domain.response.JSONResult;
import com.common.util.EnvUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.currentThread;

@ControllerAdvice(basePackages ={ "com.web.admin.controller","com.web.site"})
@Slf4j
public class ExceptionHandlerAdvice {

    @Autowired
    MailUtils mailUtils;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    EnvUtils envUtils;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JSONResult exceptionHandler(HttpServletRequest httpServletRequest, Exception ex) {
        ex.printStackTrace();

        StringBuilder errorData = getErrorData(ex);
        String requestURI = httpServletRequest.getRequestURI();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        String paramsStr="";
        if (parameterMap!=null){
//            paramsStr=JSON.toJSONString(parameterMap);
        }
        errorData.append("请求地址:<br>").append(requestURI)
                .append("<br> 请求参数:<br>" ).append(paramsStr).append("<br>");
        log.error("---------errorData{}",errorData);
        List<String> toMailList=new ArrayList<>();
        toMailList.add(mailProperties.getTo_mail());
        if(!envUtils.isDevActive()) {
            try {
                mailUtils.sendMails(toMailList, "错误故障", errorData.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONResult.error(SysErrorCodeEnum.ERR_SYSTEM.getCode(),SysErrorCodeEnum.ERR_SYSTEM.getMsg());
    }

    private StringBuilder getErrorData(Throwable ex){
        StringBuilder error=new StringBuilder();
        OutputStream ops=new ByteArrayOutputStream();
        ex.printStackTrace(new PrintStream(ops));
        error.append(ops.toString()).append("<br>");
        error.append("线程号:").append(currentThread().getId())
            .append("，线程名:").append(currentThread().getName()).append("<br>");
        return error;
    }

}
