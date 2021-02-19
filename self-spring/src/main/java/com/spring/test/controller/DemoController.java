package com.spring.test.controller;

import com.spring.formework2.annotation.Autowired;
import com.spring.formework2.annotation.Controller;
import com.spring.formework2.annotation.RequestMapping;
import com.spring.formework2.annotation.RequestParam;
import com.spring.formework2.webmvc.ModelAndView;
import com.spring.test.service.IModifyService;
import com.spring.test.service.IQueryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DemoController {


    @Autowired
    IQueryService queryService;
    @Autowired
    IModifyService modifyService;

    @RequestMapping("/query.json")
    public ModelAndView query(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("name") String name){
        String result = queryService.query(name);
        System.out.println(result);
        return out(response,result);
    }

    @RequestMapping("/add*.json")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam("name") String name, @RequestParam("addr") String addr){
        String result = modifyService.add(name,addr);
        return out(response,result);
    }


    @RequestMapping("/remove.json")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("id") Integer id){
        String result = modifyService.remove(id);
        return out(response,result);
    }



    @RequestMapping("/edit.json")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("id") Integer id,
                             @RequestParam("name") String name){
        String result = modifyService.edit(id,name);
        return out(response,result);
    }


    private ModelAndView out(HttpServletResponse resp, String str){
        try {
            resp.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
