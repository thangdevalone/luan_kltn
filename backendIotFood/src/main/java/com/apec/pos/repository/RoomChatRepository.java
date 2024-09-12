package com.apec.pos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RoomChatEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class RoomChatRepository extends BaseRepository<RoomChatEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public RoomChatRepository() {
        super(RoomChatEntity.class);
        // TODO Auto-generated constructor stub
    }

    public List<RoomChatEntity> getListRoom(Integer id) {
        String queryString = "FROM RoomChatEntity c WHERE c.shipperId =:id or c.userId =:id";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
