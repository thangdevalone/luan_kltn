package com.apec.pos.dto.FoodDto;

import java.util.List;

public class FoodResponseAdmin {

    private long totalRow;
    private List<FoodRecommendDto> data;

    public long gettotalRow() {
        return totalRow;
    }

    public void settotalRow(long totalRow) {
        this.totalRow = totalRow;
    }

    public List<FoodRecommendDto> getData() {
        return data;
    }

    public void setData(List<FoodRecommendDto> data) {
        this.data = data;
    }

    public FoodResponseAdmin(long totalRow, List<FoodRecommendDto> data) {
        super();
        this.totalRow = totalRow;
        this.data = data;
    }
}
