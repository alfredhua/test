package com.es.resp;

import com.es.entity.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

/**
 * @auth guozhenhua
 * @date 2020/03/29
 */
public interface PersonRepository extends BaseRepository<Person,Long> {


    List<Person> findByDesc(String desc);

    List<Person> findByName(String name, Pageable pageable);

    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    List<Person> find(String name);



}
