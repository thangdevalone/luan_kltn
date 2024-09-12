package com.apec.pos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.TypeFoodEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class TypeFoodRepository extends BaseRepository<TypeFoodEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public TypeFoodRepository() {
        super(TypeFoodEntity.class);
        // TODO Auto-generated constructor stub
    }

    public List<TypeFoodEntity> paging(PageRequest pageRequest) {
        String query = "FROM TypeFoodEntity c";
        return query(query, false, pageRequest);
    }

    public List<TypeFoodEntity> searchType(String key) {
        if (key == null) {
            String queryString = "SELECT c FROM TypeFoodEntity c ";
            Query query = entityManager.createQuery(queryString);
            return query.setMaxResults(20).getResultList();
        }
        String queryString = "SELECT c FROM TypeFoodEntity c "
                + "WHERE c.nameType like :key";
        Query query2 = entityManager.createQuery(queryString);
        query2.setParameter("key", "%" + key + "%");
        return query2.setMaxResults(10).getResultList();
    }

}
