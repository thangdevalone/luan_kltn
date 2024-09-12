package com.apec.pos.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class TypeFoodEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    private String nameType;

    private String imgType;

    @OneToMany(mappedBy = "typeFoodEntity")
    @JsonManagedReference(value = "type-food")
    private List<FoodEntity> foodEntities;


    public TypeFoodEntity(String createBy, String modifiedBy) {
        super(createBy, modifiedBy);
    }


    public TypeFoodEntity() {

    }

    public TypeFoodEntity(String createBy, String modifiedBy, Integer id, String nameType, String imgType,
                          List<FoodEntity> foodEntities) {
        super(createBy, modifiedBy);
        this.id = id;
        this.nameType = nameType;
        this.imgType = imgType;
        this.foodEntities = foodEntities;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }


    public List<FoodEntity> getFoodEntities() {
        return foodEntities;
    }


    public void setFoodEntities(List<FoodEntity> foodEntities) {
        this.foodEntities = foodEntities;
    }


    public TypeFoodEntity(String createBy, String modifiedBy, Integer id, String nameType) {
        super(createBy, modifiedBy);
        this.id = id;
        this.nameType = nameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }


}
