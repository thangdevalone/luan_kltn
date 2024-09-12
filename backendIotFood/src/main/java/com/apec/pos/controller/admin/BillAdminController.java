package com.apec.pos.controller.admin;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.response.Response;
import com.apec.pos.service.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class BillAdminController {

    @Autowired
    private BillService billService;

    @Operation(summary = "lấy ra bill phía ADMIN")
    @RequestMapping(value = "get-bill",method = RequestMethod.POST)
    public ResponseEntity getBill(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) OrderStatus orderStatus){
        return ResponseEntity.ok(new Response(true,"", ErrorCode.SUCCESS,billService.getBill(pageIndex,pageSize,orderStatus)));
    }

    @RequestMapping(value = "update-bill",method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestParam OrderStatus orderStatus,@RequestParam Integer id){
        try{
            return  ResponseEntity.ok(new Response<>(true,"",ErrorCode.SUCCESS,billService.updateBill(orderStatus,id)));
        }catch (Exception ex){
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @RequestMapping(value = "get-detail-bill",method = RequestMethod.POST)
    public ResponseEntity getDetailBill(@RequestParam Integer id){
        return ResponseEntity.ok(new Response<>(true,"",ErrorCode.SUCCESS,billService.getDetailBill(id)));
    }

}
