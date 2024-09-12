package com.apec.pos.dto.billDTO;

import com.apec.pos.dto.ToppingDTO.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseBill {
    private Integer foodId;
    private String nameFood;
    private Integer priceFood;
    private Integer quantity;
    private String nameRes;
    private Integer resId;
    private List<Item> itemList;
    private String address;

}
