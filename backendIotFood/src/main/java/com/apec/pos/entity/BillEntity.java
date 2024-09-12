package com.apec.pos.entity;


import com.apec.pos.enu.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillEntity extends BaseEntity {

    private Date finishDate;
    private OrderStatus orderStatus;
    private long totalAmount;
    private String orderBy;
    private String nameRes;
    private String finishTime;
    private int shipFee;
    private String code;
    private String note;


    @Column(name = "accountEntityId")
    private Integer accountEntityId;

    @OneToMany(mappedBy = "billEntity",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "bill-detail")
    private List<BillDetailEntity> billDetailEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "bill-account")
    @JoinColumn(name = "accountEntityId",updatable = false,insertable = false)
    private AccountEntity accountEntity;


}
