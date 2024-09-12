package com.apec.pos.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apec.pos.entity.MessageEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class MessageRepository extends BaseRepository<MessageEntity, Integer> {

    @Autowired
    private EntityManager entityManager;

    public MessageRepository() {
        super(MessageEntity.class);
    }

    public List<MessageEntity> getListLassMess(Integer id) {
        String queryString = "FROM MessageEntity c WHERE c.accountEntityId =:id ORDER BY c.id DESC";
        Query query = entityManager.createQuery(queryString).setParameter("id", id);
        return query.setMaxResults(1).getResultList();
    }

    public List<MessageEntity> getListChatRoom(Integer id) {
        String queryString = "FROM MessageEntity c WHERE c.roomChatEntityId =:id ORDER BY c.createDate DESC";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
