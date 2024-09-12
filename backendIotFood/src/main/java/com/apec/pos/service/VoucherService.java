package com.apec.pos.service;

import com.apec.pos.dto.voucherDTO.VoucherRequest;
import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.entity.VoucherEntity;
import com.apec.pos.repository.VoucherReposioty;
import com.apec.pos.service.serviceInterface.VoucherInteface;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class VoucherService extends BaseService<VoucherReposioty,VoucherEntity,Integer> implements VoucherInteface{

    @Autowired
    private VoucherReposioty voucherReposioty;
    @Override
    public VoucherResponse useVoucher(VoucherRequest voucherRequest) throws Exception {
        VoucherEntity voucherEntity = voucherReposioty.findOne(voucherRequest.getId());
        if (voucherEntity==null){
            throw new Exception("Không tìm thấy voucher");
        }
        if (voucherEntity.getExpired().isBefore(LocalDate.now())){
            throw new Exception("Voucher hết hạn");
        }
        voucherReposioty.delete(voucherRequest.getId());
        PageRequest pageRequest = PageRequest.of(voucherRequest.getPageIndex(), voucherRequest.getPageSize());
        return new VoucherResponse((int) voucherReposioty.countAll(),voucherReposioty.paging(pageRequest));
    }

    @Override
    public VoucherResponse pagingVoucher(Integer pageIndex, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);
        VoucherResponse voucherResponse = new VoucherResponse((int) voucherReposioty.countAll(),voucherReposioty.paging(pageRequest));
        return voucherResponse;
    }

    @Override
    public void multiDelete(Set<Integer> ids) {
        for (Integer x:
             ids) {
            voucherReposioty.delete(x);
        }
    }

    @Override
    public VoucherEntity updateVoucher(VoucherEntity voucherEntity) {
        VoucherEntity voucherNew = voucherReposioty.findOne(voucherEntity.getId());
        voucherNew.setCode(voucherEntity.getCode()!=null ? voucherEntity.getCode() : voucherNew.getCode());
        voucherNew.setTitle(voucherEntity.getTitle() !=null ? voucherEntity.getTitle() : voucherNew.getTitle());
        voucherNew.setExpired(voucherEntity.getExpired() != null ? voucherEntity.getExpired() : voucherNew.getExpired());
        voucherNew.setQuantity(voucherEntity.getQuantity() !=null ? voucherEntity.getQuantity() : voucherEntity.getQuantity());
        voucherNew.setDetail(voucherEntity.getDetail() != null ? voucherEntity.getDetail() : voucherNew.getDetail());
        voucherNew.setDiscount(voucherEntity.getDiscount() != null ? voucherEntity.getDiscount() : voucherNew.getDiscount());

        return voucherReposioty.update(voucherNew);
    }

    // Phương thức này sẽ được thực hiện sau mỗi 2 ngày
    @Scheduled(fixedRate = 2 * 24 * 60 * 60 * 1000) // Khoảng thời gian được tính bằng mili giây
    public void checkEveryTwoDays() {
        voucherReposioty.deleteVoucherExpired();
    }


    @Override
    VoucherReposioty getRepository() {
        return voucherReposioty;
    }
}
