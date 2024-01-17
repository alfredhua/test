package com.hbatis.v2.mapper;


import com.hbatis.v2.annotion.Entity;
import com.hbatis.v2.annotion.Select;

@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = ?")
    Blog selectBlogById(Integer bid);

}
