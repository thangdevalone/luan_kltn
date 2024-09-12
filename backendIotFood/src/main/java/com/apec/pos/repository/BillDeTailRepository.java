package com.apec.pos.repository;

import com.apec.pos.entity.BillDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BillDeTailRepository extends BaseRepository<BillDetailEntity,Integer>{
    public BillDeTailRepository() {
        super(BillDetailEntity.class);
    }
}
