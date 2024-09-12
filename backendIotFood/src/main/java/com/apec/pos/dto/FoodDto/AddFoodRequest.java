package com.apec.pos.dto.FoodDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFoodRequest implements Serializable {

    private Integer id;
    private String foodName;
    private Integer price;
    private String detail;
    private MultipartFile imgFood;
    @NotNull(message = "typeFoodEntityId không được để trống")
    private Integer typeFoodEntityId;
    @NotNull(message = "restaurantEntityId không được để trống")
    private Integer restaurantEntityId;
}
