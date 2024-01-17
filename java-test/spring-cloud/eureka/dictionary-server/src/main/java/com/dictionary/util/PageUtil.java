package com.dictionary.util;


import com.dictionary.response.PageBean;

/**
 * @author hua
 */
public class PageUtil {

    public static PageBean validatePage(Integer page, Integer pageSize){
        PageBean pageResult=new PageBean();
        if(page!=null&&page>0){
            pageResult.setPage(page);
        }else{
            pageResult.setPage(0);
        }
        if(pageSize!=null){
            pageResult.setPage_size(pageSize);
        }
        pageResult.setOff_set(pageResult.getPage()*pageResult.getPage_size());
        return pageResult;
    }
}
