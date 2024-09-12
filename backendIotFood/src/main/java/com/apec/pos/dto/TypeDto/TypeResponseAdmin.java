package com.apec.pos.dto.TypeDto;

import java.util.List;

public class TypeResponseAdmin {

    private Long totalRow;
    private List<TypefoodResponseData> data;

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    public List<TypefoodResponseData> getData() {
        return data;
    }

    public void setData(List<TypefoodResponseData> data) {
        this.data = data;
    }

}
