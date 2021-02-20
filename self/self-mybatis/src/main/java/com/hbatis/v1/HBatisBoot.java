package com.hbatis.v1;

import com.hbatis.v1.mapper.BlogMapper;

public class HBatisBoot {

  public static void main(String[] args){
    HSqlSession sqlSession=new HSqlSession(new HConfiguration(),new HExecutor());
    BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
    blogMapper.selectBlogById(1);

  }
}
