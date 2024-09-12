package com.apec.pos.dto.FoodDto;


public class FoodSearchRespon {

    private Integer id;
    private String foodName;
    private String detail;
    private Integer price;
    private Integer quantity;
    private Integer quantityPurchased;
    private String imgFood;

    public FoodSearchRespon(Integer id, String foodName, String detail, Integer price, Integer quantity,
                            Integer quantityPurchased, String imgFood) {
        super();
        this.id = id;
        this.foodName = foodName;
        this.detail = detail;
        this.price = price;
        this.quantity = quantity;
        this.quantityPurchased = quantityPurchased;
        this.imgFood = imgFood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public String getImgFood() {
        return imgFood;
    }

    public void setImgFood(String imgFood) {
        this.imgFood = imgFood;
    }


}
