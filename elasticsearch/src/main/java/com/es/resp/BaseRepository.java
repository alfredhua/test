package com.es.resp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author guozhenhua
 * @date 2020/03/29
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>  extends Repository<T, ID>  {


    // Saves the given entity.
    <S extends T> S save(S entity);

    // Returns the entity identified by the given ID.
    Optional<T> findById(ID primaryKey);

    // Returns all entities.
    Iterable<T> findAll();

    // Returns the number of entities.
    long count();

    // Deletes the given entity.
    void delete(T entity);

    // Indicates whether an entity with the given ID exists.
    boolean existsById(ID primaryKey);

    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll(Sort sort);


}
