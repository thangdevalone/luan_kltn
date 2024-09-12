package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class BillDetailEntity extends BaseEntity{

    @Column
    private Integer quantity;

    @Column
    private String item;

    @Column(name = "foodEntityId")
    private Integer foodEntityId;

    @Column(name = "billEntityId")
    private Integer billEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "food-bill-detail")
    @JoinColumn(name = "foodEntityId",updatable = false,insertable = false)
    private FoodEntity foodEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "bill-detail")
    @JoinColumn(name = "billEntityId",updatable = false,insertable = false)
    private BillEntity billEntity;


}
