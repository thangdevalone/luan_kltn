package com.apec.pos.service;

import java.io.Serializable;
import java.util.List;

import com.apec.pos.repository.BaseRepository;

public abstract class BaseService<R extends BaseRepository<E, ID>, E, ID extends Serializable> {
    abstract R getRepository();

    public List<E> findAll() {
        return getRepository().findAll();
    }

    public E findOne(ID id) {
        return getRepository().findOne(id);
    }

    public long countAll() {
        return getRepository().countAll();
    }

    public E create(E entity) {
        return getRepository().insert(entity);
    }

    public E update(E entity) {
        return getRepository().update(entity);
    }

    public List<E> create(List<E> entities) {
        getRepository().insert(entities);
        return entities;
    }

    public long delete(ID id) {
        return getRepository().delete(id);
    }


}
