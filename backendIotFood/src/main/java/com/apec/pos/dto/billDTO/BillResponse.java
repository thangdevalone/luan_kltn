package com.apec.pos.dto.billDTO;

import com.apec.pos.dto.accountDto.LoginResponDto;
import com.apec.pos.dto.voucherDTO.VoucherResponseBill;
import com.apec.pos.enu.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillResponse {
    private Integer id;
    private Date createAt;
    private OrderStatus orderStatus;
    private String nameRestaurant;
    private int shipFee;
    private String finishTime;
    private int accountId;
    private int totalAmount;
    private String note;
    private LoginResponDto user;
    private VoucherResponseBill voucherResponseBill;
    private List<FoodResponseBill> foodResponseBills;
}
