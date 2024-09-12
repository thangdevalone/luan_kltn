package com.apec.pos.dto.ToppingDTO;

import com.apec.pos.dto.ToppingDTO.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToppingResponse {
    private Integer id;
    private String title;
    private Boolean requi;
    private List<Item> itemList;
}
