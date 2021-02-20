package com.dictionary.service.dao.mapper;

import com.dictionary.service.dao.entity.AuthDictionary;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hua
 */
@Mapper
public interface AuthDictionaryMapper {


    @Select("select * from manage_dictionary.dic_auth where parent_id=#{parentId} order by parent_id limit #{offset},#{pageSize}")
    List<AuthDictionary> listAuthDictionary(@Param("parentId")Integer parentId,  @Param("offset") Integer offset,@Param("pageSize") Integer pageSize);

    @Select("select count(*) from manage_dictionary.dic_auth where parent_id=#{parentId}  order by parent_id ")
    Integer listAuthDictionaryCount(@Param("parentId") Integer parentId);

    @Insert("insert into manage_dictionary.dic_auth(value,href,comment,parent_id)" +
            "values (#{value},#{href},#{comment},#{parent_id}) ")
    void createAuthDictionary(AuthDictionary authDictionary);

    @Select("select * from manage_dictionary.dic_auth where id=#{parent_id}")
    AuthDictionary getAuthDictionaryById(@Param("parent_id") Integer parentId);

    @Update("update manage_dictionary.dic_auth set value=#{value},href=#{href},comment=#{comment} where id=#{id}")
    boolean editAuthDictionary(AuthDictionary authDictionary);

    @Delete("delete from manage_dictionary.dic_auth where id=#{id}")
    boolean delAuthDictionary(@Param("id") Integer id);
}
