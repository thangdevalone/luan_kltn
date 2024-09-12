package com.apec.pos.controller.admin;

import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.entity.VoucherEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.repository.VoucherReposioty;
import com.apec.pos.response.Response;
import com.apec.pos.service.VoucherService;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "ADMIN")
public class VoucherAdminController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherReposioty voucherReposioty;
    @RequestMapping(value = "add-voucher",method = RequestMethod.POST)
    public ResponseEntity addVoucher(@RequestBody VoucherEntity voucherEntity){
        return ResponseEntity.ok(new Response(true,"",voucherReposioty.insert(voucherEntity)));
    }
    @RequestMapping(value = "update-voucher",method = RequestMethod.PUT)
    public ResponseEntity updateVoucher(@RequestBody VoucherEntity voucherEntity){
        return ResponseEntity.ok(new Response(true,"",voucherService.updateVoucher(voucherEntity)));
    }
    @RequestMapping(value = "delete-voucher",method = RequestMethod.POST)
    public ResponseEntity deleteVoucher(@RequestBody Set<Integer> ids){
        try{
            voucherService.multiDelete(ids);
            return ResponseEntity.ok(new Response<>(true,"thành công"));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,e.getMessage()));
        }
    }
    @RequestMapping(value = "paging-voucher",method = RequestMethod.POST)
    public ResponseEntity pagingVoucher(@RequestParam Integer pageIndex,@RequestParam Integer pageSize){

        return ResponseEntity.ok(new Response<>(true,"",voucherService.pagingVoucher(pageIndex,pageSize)));
    }
    @RequestMapping(value = "get-detail-voucher",method = RequestMethod.POST)
    public ResponseEntity getDetailVoucher(@RequestParam Integer id){
        return ResponseEntity.ok(new Response<>(true,"",voucherService.findOne(id)));
    }
}
