package com.hbatis.v2;

import com.hbatis.v2.mapper.Blog;
import com.hbatis.v2.mapper.BlogMapper;
import com.hbatis.v2.session.SqlSessionFactoryBuild;

public class TestHbatis {

  public static void main(String[] args) {
    BlogMapper mapper = new SqlSessionFactoryBuild().build().openSqlSession().getMapper(BlogMapper.class);
    Blog blog = mapper.selectBlogById(1);
    System.out.println(blog);
  }

}
