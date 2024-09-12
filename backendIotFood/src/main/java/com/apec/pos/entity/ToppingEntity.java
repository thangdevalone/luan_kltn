package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToppingEntity extends BaseEntity {
    private String title;
    private String items;
    private Boolean requi;

    @Column(name = "restaurantEntityId")
    private Integer restaurantEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "topping-res")
    @JoinColumn(name = "restaurantEntityId",insertable = false,updatable = false)
    private RestaurantEntity restaurantEntity;


}
