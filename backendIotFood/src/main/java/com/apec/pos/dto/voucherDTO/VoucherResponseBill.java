package com.apec.pos.dto.voucherDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherResponseBill {
    private String code;
    private int discount;
    private LocalDate expired;
    private Date createDate;
}
