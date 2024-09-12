package com.apec.pos.repository;

import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.entity.VoucherEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VoucherReposioty extends BaseRepository<VoucherEntity,Integer>{

    @Autowired
    private EntityManager entityManager;
    public VoucherReposioty() {
        super(VoucherEntity.class);
    }

    public List<VoucherEntity> paging(PageRequest pageRequest) {
        String query = "SELECT c FROM VoucherEntity c";
        Map<String, Object> params = new HashMap<>();
        return query(query, false, params, pageRequest);
    }

    public List<VoucherEntity> pagingVoucherUser(PageRequest pageRequest) {
        String query = "SELECT c FROM VoucherEntity c WHERE c.expired > :currentDate";
        Map<String, Object> params = new HashMap<>();
        params.put("currentDate", LocalDate.now());
        return query(query, false, params, pageRequest);
    }

    @Transactional
    public int deleteVoucherExpired(){
        String query = "DELETE FROM VoucherEntity c WHERE c.expired < :currentDate";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("currentDate", LocalDate.now());
        return query1.executeUpdate();
    }

    public VoucherEntity findVoucherByCode(String code){
        String query = "SELECT c FROM VoucherEntity c WHERE c.code =:code";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("code",code);
        List<VoucherEntity> voucherEntities = query1.getResultList();
        if (voucherEntities.isEmpty()){
            return null;
        }
        else {
            VoucherEntity voucherEntity = voucherEntities.get(0);
            return voucherEntity;
        }

    }

}
