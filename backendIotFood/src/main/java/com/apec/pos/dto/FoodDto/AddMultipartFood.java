package com.apec.pos.dto.FoodDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddMultipartFood {
    private String foodName;
    private Integer price;
    private String detail;
    private String imgFood;
    private Integer typeFoodEntityId;
    private Integer restaurantEntityId;
}
