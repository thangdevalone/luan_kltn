package com.apec.pos.dto.FoodDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.subtyping.qual.Bottom;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFood {
    private Integer id;
    private String foodName;
    private Integer price;
    private String detail;
    private MultipartFile imgFood;
    private Integer typeFoodEntityId;
    private Integer restaurantEntityId;
}
