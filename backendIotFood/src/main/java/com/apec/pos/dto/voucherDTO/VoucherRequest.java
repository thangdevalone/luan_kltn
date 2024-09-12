package com.apec.pos.dto.voucherDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoucherRequest {
    private Integer id;
    private Integer pageIndex;
    private Integer pageSize;
}
