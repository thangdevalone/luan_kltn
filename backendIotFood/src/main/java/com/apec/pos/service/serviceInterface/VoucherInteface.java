package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.voucherDTO.VoucherRequest;
import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.entity.VoucherEntity;

import java.util.List;
import java.util.Set;

public interface VoucherInteface {
    public VoucherResponse useVoucher(VoucherRequest voucherRequest) throws Exception;

    public VoucherResponse pagingVoucher(Integer pageIndex,Integer pageSize);

    public void multiDelete(Set<Integer> ids);
    public VoucherEntity updateVoucher(VoucherEntity voucherEntity);
}
