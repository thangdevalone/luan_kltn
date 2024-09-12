package com.apec.pos.repository;

import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.entity.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository extends BaseRepository<RoleEntity,Integer>{
    public RoleRepository() {
        super(RoleEntity.class);
    }
}
