package com.apec.pos.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;


@Entity
@Data
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    private String authority;

    public RoleEntity(String createBy, String modifiedBy) {
        super(createBy, modifiedBy);
    }

    public RoleEntity(String createBy, String modifiedBy, long id, String authority) {
        super(createBy, modifiedBy);

        this.authority = authority;
    }


    public RoleEntity() {
        super();
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
