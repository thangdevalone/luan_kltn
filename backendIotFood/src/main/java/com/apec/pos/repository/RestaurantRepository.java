package com.apec.pos.repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.apec.pos.entity.FoodEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RestaurantEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class RestaurantRepository extends BaseRepository<RestaurantEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public RestaurantRepository() {
        super(RestaurantEntity.class);
    }

    public List<RestaurantEntity> paging(PageRequest pageRequest) {
        String query = "SELECT c FROM RestaurantEntity c";
        Map<String, Object> params = new HashMap<>();
        return query(query, false, params, pageRequest);
    }

    public List<RestaurantEntity> getRecommendRes() {
        String queryString = "SELECT c FROM RestaurantEntity c ORDER BY c.quantitySold DESC";
        Query query = entityManager.createQuery(queryString);
        return query.setMaxResults(10).getResultList();
    }

    public List<RestaurantEntity> searchRes(String key) {
        if (key == null) {
            String queryString = "SELECT c FROM RestaurantEntity c ";
            Query query = entityManager.createQuery(queryString);
            return query.setMaxResults(20).getResultList();
        }
        String queryString = "SELECT c FROM RestaurantEntity c "
                + "WHERE c.restaurantName like :key";

        Query query2 = entityManager.createQuery(queryString);
        query2.setParameter("key", "%" + key + "%");
        return query2.setMaxResults(10).getResultList();
    }

    @Transactional
    public void updateQuantity( int quantity,int resId){
        String query = "UPDATE RestaurantEntity c SET c.quantitySold = c.quantitySold + :quantity WHERE c.id =:resId";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("quantity", quantity);
        query1.setParameter("resId",resId);
        int updatedRows = query1.executeUpdate();
    }
}
