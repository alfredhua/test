package com.dictionary.response;

import com.dictionary.service.dao.entity.AuthDictionary;
import lombok.Data;

/**
 * @author hua
 */
@Data
public class ListAuthDictionaryResponse {

    PageBean<AuthDictionary> pageBean;

    AuthDictionary parentAuthDictionary;

}
