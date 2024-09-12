package com.apec.pos.repository;

import com.apec.pos.entity.ToppingEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToppingRepository extends BaseRepository<ToppingEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public ToppingRepository() {
        super(ToppingEntity.class);
    }


    @Transactional
    public void deleteByResId(int id){
        String query = "DELETE  FROM ToppingEntity c WHERE c.restaurantEntityId =:id";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("id",id);
        query1.executeUpdate();
    }

}
