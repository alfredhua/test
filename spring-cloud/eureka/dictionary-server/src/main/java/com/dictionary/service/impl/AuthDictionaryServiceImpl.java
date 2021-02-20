package com.dictionary.service.impl;


import com.dictionary.response.ListAuthDictionaryResponse;
import com.dictionary.response.PageBean;
import com.dictionary.response.ResultResponse;
import com.dictionary.service.dao.entity.AuthDictionary;
import com.dictionary.service.dao.mapper.AuthDictionaryMapper;
import com.dictionary.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author hua
 */

@Component
public class AuthDictionaryServiceImpl {

    @Autowired
    AuthDictionaryMapper authDictionaryMapper;


    public ListAuthDictionaryResponse listAuthDictionary(Integer parent_id, Integer page, Integer page_size) {
        ListAuthDictionaryResponse listAuthDictionaryResponse=new ListAuthDictionaryResponse();
        PageBean<AuthDictionary> pageBean = PageUtil.validatePage(page, page_size);
        pageBean.setList(authDictionaryMapper.listAuthDictionary(parent_id, pageBean.getOff_set(), pageBean.getPage_size()));
        pageBean.setTotal(authDictionaryMapper.listAuthDictionaryCount(parent_id));
        listAuthDictionaryResponse.setPageBean(pageBean);
        listAuthDictionaryResponse.setParentAuthDictionary(authDictionaryMapper.getAuthDictionaryById(parent_id));
        return listAuthDictionaryResponse;
    }


    public ResultResponse createAuthDictionary(AuthDictionary authDictionary) {
        if(ObjectUtils.isEmpty(authDictionaryMapper.getAuthDictionaryById(authDictionary.getParent_id()))){
            ResultResponse.error("parent_id_error","父节点不存在");
        }
        authDictionaryMapper.createAuthDictionary(authDictionary);
        return ResultResponse.success();
    }

    public ResultResponse editAuthDictionary(AuthDictionary authDictionary){
        if(authDictionaryMapper.editAuthDictionary(authDictionary)){
            return ResultResponse.success();
        }else{
            return ResultResponse.editError();
        }
    }

    public ResultResponse delAuthDictionary(Integer id) {
        if(authDictionaryMapper.delAuthDictionary(id)){
            return ResultResponse.success();
        }else{
            return ResultResponse.delError();
        }
    }
}
