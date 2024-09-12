package com.apec.pos.repository;

import com.apec.pos.entity.BaseEntity;
import com.apec.pos.entity.BillEntity;
import com.apec.pos.enu.OrderStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BillRepository extends BaseRepository<BillEntity, Integer> {
    public BillRepository() {
        super(BillEntity.class);
    }

    public List<BillEntity> pagingBill(PageRequest pageRequest, OrderStatus orderStatus){
        String query = "SELECT c FROM BillEntity c WHERE 1=1";
        Map<String, Object> params = new HashMap<>();
        if (orderStatus!=null){
            query +=" and c.orderStatus =:orderStatus ";
            params.put("orderStatus",orderStatus);
        }
        return query(query,false,params,pageRequest);
    }

    public List<BillEntity> pagingUserBill(PageRequest pageRequest,OrderStatus orderStatus,Integer accountId){
        String query = "SELECT c FROM BillEntity c WHERE c.accountEntityId =:accountId";
        Map<String, Object> params = new HashMap<>();
        if (orderStatus!=null){
            query +=" and c.orderStatus =:orderStatus ";
            params.put("orderStatus",orderStatus);
        }
        params.put("accountId",accountId);
        return query(query,false,params,pageRequest);
    }

    public long countBill(Integer accountId,OrderStatus orderStatus){
        String query = "SELECT count(c.id) FROM BillEntity c WHERE 1=1";
        Map<String, Object> params = new HashMap<>();
        if (accountId!=null){
            query += " and c.accountEntityId =:accountId ";
            params.put("accountId",accountId);
        }
        if (orderStatus !=null){
            query +=" and c.orderStatus =:orderStatus ";
            params.put("orderStatus",orderStatus);
        }

        return count(query,false,params);
    }
}
