package com.apec.pos.dto.ToppingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToppingRequestAdd {
    private String name;
    private Integer price;

}
