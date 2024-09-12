package com.apec.pos.repository;

import java.io.Serializable;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

public class BaseRepository<T, ID extends Serializable> {
    @Autowired
    private EntityManager entityManager;
    private final Class entityClass;

    public BaseRepository(Class entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public T insert(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public List<T> insert(List<T> listEntities, int batchSize) {
        if (listEntities != null && !listEntities.isEmpty()) {
            for (int i = 0; i < listEntities.size(); i++) {
                insert(listEntities.get(i));
                if (i % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
        }
        return listEntities;
    }

    @Transactional
    public List<T> insert(List<T> listEntities) {
        return insert(listEntities, 50);
    }

    @Transactional
    public T update(T entity) {
        entityManager.merge(entity);
        //entityManager.flush();
        //entityManager.refresh(entity);
        return entity;
    }

    @Transactional
    public int update(CriteriaUpdate<T> criUpdate) {
        Query query = entityManager.createQuery(criUpdate);
        return query.executeUpdate();
    }

    @Transactional
    public int update(String queryStr, boolean isNative) {
        Query query = buildQuery(queryStr, isNative);
        return query.executeUpdate();
    }

    @Transactional
    public int update(String queryStr, boolean isNative, Map<String, Object> params) {
        Query query = buildQueryHasParameters(queryStr, isNative, params);
        return query.executeUpdate();
    }

    @Transactional
    public int delete(T entity) {
        entityManager.remove(entity);
        return 1;
    }

    @Transactional
    public int delete(CriteriaDelete criDelete) {
        Query query = entityManager.createQuery(criDelete);
        return query.executeUpdate();
    }

    @Transactional
    public int delete(ID id) {
        CriteriaBuilder criBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> criDel = criBuilder.createCriteriaDelete(entityClass);
        Root<T> root = criDel.from(entityClass);
        criDel.where(criBuilder.equal(root.get("id"), id));
        int result = entityManager.createQuery(criDel).executeUpdate();
        return result;
    }

    @Transactional
    public int deleteByQuery(String queryStr, boolean isNative) {
        Query query = buildQuery(queryStr, isNative);
        return query.executeUpdate();
    }

    @Transactional
    public int deleteByQuery(String queryStr, boolean isNative, Map<String, Object> params) {
        Query query = buildQueryHasParameters(queryStr, isNative, params, entityClass);
        return query.executeUpdate();
    }

    /**
     * *
     * DELETE BY PARAM
     *
     * @param queryStr
     * @param params
     * @return
     */
    @Transactional
    public int deleteByQuery(String queryStr, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(queryStr);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.executeUpdate();
    }


    public T findOne(ID id) {
        return (T) entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        Query createQuery = entityManager.createQuery("From " + this.entityClass.getSimpleName());
        return createQuery.getResultList();
    }

    public long countAll() {
        String queryStr = "SELECT COUNT(e) from " + entityClass.getSimpleName() + " e";
        Query createQuery = entityManager.createQuery(queryStr);
        return (long) createQuery.getSingleResult();
    }

    public long count(String jpaQuery, boolean isNative, Map<String, Object> params) {
        Query createQuery = buildQueryHasParameters(jpaQuery, isNative, params, null);
        return ((Number) createQuery.getSingleResult()).longValue();
    }

    private Query buildQuery(String query, boolean isNative) {
        return buildQuery(query, isNative, null);
    }

    private Query buildQuery(String query, boolean isNative, Class clazz) {
        Query createdQuery;
        if (isNative) {
            if (clazz != null) {
                createdQuery = entityManager.createNativeQuery(query, clazz);
            } else {
                createdQuery = entityManager.createNativeQuery(query);
            }
        } else {
            createdQuery = entityManager.createQuery(query);
        }
        return createdQuery;
    }


    private Query buildQueryHasParameters(String query, boolean isNative, Map<String, Object> params) {
        return buildQueryHasParameters(query, isNative, params, null);
    }

    private Query buildQueryHasParameters(String query, boolean isNative, Map<String, Object> params, Class clazz) {
        Query createdQuery;
        if (clazz != null) {
            createdQuery = buildQuery(query, isNative, clazz);
        } else {
            createdQuery = buildQuery(query, isNative);
        }
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                createdQuery.setParameter(key, params.get(key));
            }
        }
        return createdQuery;
    }

    public List<T> query(String query, boolean isNative) {
        return query(query, isNative, null, null, entityClass);
    }

    public List<T> query(String query, boolean isNative, Map<String, Object> params) {
        return query(query, isNative, params, null, entityClass);
    }

    public <R> List<R> query(String query, boolean isNative, Map<String, Object> params, Class<R> resultClazz) {
        return query(query, isNative, params, null, resultClazz);
    }

    public List<T> query(String query, boolean isNative, PageRequest paging) {
        return query(query, isNative, null, paging, entityClass);
    }

    public <R> List<R> query(String query, boolean isNative, PageRequest paging, Class<R> resultClazz) {
        return query(query, isNative, null, paging, resultClazz);
    }

    public List<T> query(String query, boolean isNative, Map<String, Object> params, PageRequest paging) {
        return query(query, isNative, params, paging, entityClass);
    }

    public <R> List<R> query(String query, boolean isNative, Map<String, Object> params, PageRequest paging, Class<R> resultClazz) {
        Query createdQuery = buildQueryHasParameters(query, isNative, params, resultClazz);
        if (paging != null) {
            return createdQuery.setFirstResult(paging.getPageNumber() * paging.getPageSize())
                    .setMaxResults(paging.getPageSize())
                    .getResultList();

        } else {
            return createdQuery.getResultList();
        }
    }


}
