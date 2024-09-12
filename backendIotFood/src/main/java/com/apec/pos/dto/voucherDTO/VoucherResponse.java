package com.apec.pos.dto.voucherDTO;

import com.apec.pos.entity.VoucherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherResponse {
    private Integer totalRow;
    private List<VoucherEntity> data;
}
