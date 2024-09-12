package com.apec.pos.repository;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.apec.pos.entity.FoodEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class FoodRepository extends BaseRepository<FoodEntity, Integer> {

    public FoodRepository() {
        super(FoodEntity.class);
    }

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void deleteWhereRestaurantId(Integer id) {
        String queryString = "DELETE FROM FoodEntity c WHERE c.restaurantEntityId  =:id";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<FoodEntity> muiltiDelete(Set<Integer> ids) {
        List<FoodEntity> deletedFoods = entityManager
                .createQuery("SELECT f FROM FoodEntity f WHERE f.id IN :ids", FoodEntity.class)
                .setParameter("ids", ids)
                .getResultList();

        for (FoodEntity food : deletedFoods) {
            entityManager.remove(food);
        }
        return deletedFoods;
    }

    public List<FoodEntity> paging(PageRequest pageRequest) {
        String query = "SELECT c FROM FoodEntity c";
        Map<String, Object> params = new HashMap<>();
        return query(query, false, params, pageRequest);
    }

    public List<FoodEntity> findFoodByKey(String key) {
        String query = "SELECT f FROM FoodEntity f LEFT JOIN TypeFoodEntity tf ON f.typeFoodEntityId = tf.id  WHERE f.foodName like :key OR f.detail like :key OR tf.nameType like :key ";
        Query query2 = entityManager.createQuery(query);
        query2.setParameter("key", "%" + key + "%");

        return query2.getResultList();
    }

    public List<FoodEntity> findFoodOnType(FoodEntity foodEntity) {
        String query = buildQuery(foodEntity);
        Map<String, Object> params = getParams(foodEntity);
        return query(query, false, params);
    }

    public List<FoodEntity> getTopFood() {
        String query = "SELECT c FROM FoodEntity c ";
        Query query2 = entityManager.createQuery(query);
        return query2.setMaxResults(10).getResultList();
    }

    @Transactional
    public void addQuantity(int quantity,int foodId){
        String query = "UPDATE  FROM FoodEntity c SET c.quantityPurchased = c.quantityPurchased + :quantity WHERE c.id =:foodId";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("quantity",quantity);
        query1.setParameter("foodId",foodId);
        query1.executeUpdate();
    }

    private String buildQuery(FoodEntity foodEntity) {
        String query = "FROM FoodEntity c WHERE 1=1 ";
        if (foodEntity.getId() != null) {
            query += " AND c.id = :id";
        }
        return query;
    }

    private Map<String, Object> getParams(FoodEntity foodEntity) {
        Map<String, Object> params = new HashMap<>();
        if (foodEntity.getId() != null) {
            params.put("id", foodEntity.getId());
        }

        return params;
    }
}
