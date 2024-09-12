package com.apec.pos.dto.restaurantDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePaging {
    private Long totalRow;
    private List<ResRecommnedRespon> responList;
}
