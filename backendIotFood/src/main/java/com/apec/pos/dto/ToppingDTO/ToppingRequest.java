package com.apec.pos.dto.ToppingDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToppingRequest implements Serializable {
    private Integer toppingId;
    private String title;
    private Boolean require;
    @NotNull(message = "ko dc null")
    private Integer resId;
    private List<Item> item;
}
