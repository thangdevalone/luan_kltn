package com.apec.pos.dto.FoodDto;

import com.apec.pos.dto.ToppingDTO.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillFoodRequest {
    private Integer foodId;
    private Integer quantity;
    private List<Item> itemList;
}
