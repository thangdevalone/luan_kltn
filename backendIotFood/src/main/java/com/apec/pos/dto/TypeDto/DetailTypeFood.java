package com.apec.pos.dto.TypeDto;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetailTypeFood {
    private Date createAt;
    private boolean status;
    private String nameType;
    private String imgType;
    private List<FoodRecommendDto> foodRecommendDtos;
}
