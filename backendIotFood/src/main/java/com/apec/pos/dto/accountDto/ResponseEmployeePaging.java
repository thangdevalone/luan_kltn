package com.apec.pos.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeePaging {
    private Integer totalRow;
    private List<LoginResponDto> data;
}
