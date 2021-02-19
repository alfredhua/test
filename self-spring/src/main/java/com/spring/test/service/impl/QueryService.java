package com.spring.test.service.impl;

import com.spring.formework2.annotation.Service;
import com.spring.test.service.IQueryService;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 查询业务
 * @author Tom
 *
 */
@Service
public class QueryService implements IQueryService {

	/**
	 * 查询
	 */
	public String query(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
		return json;
	}

}
