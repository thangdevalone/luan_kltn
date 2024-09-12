package com.apec.pos.controller.user;

import com.apec.pos.PosApplication;
import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.response.Response;
import com.apec.pos.service.BillService;
import com.apec.pos.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.criteria.Order;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "user")
public class BillController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BillService billService;

//    @Operation(summary = "Them bill")
//    @RequestMapping(value = "add-bill", method = RequestMethod.POST)
    @MessageMapping("/app/add-bill")
    @SendTo("/topic/add-bill")
    public ResponseEntity addBill(@RequestBody BillRequest billRequest, SimpMessageHeaderAccessor headerAccessor) {
        String someHeader =  headerAccessor.getNativeHeader("Authorization").get(0);
        String username =jwtService.getUsernameFromToken(someHeader.substring(7));

//        if (billRequest.getFinishTime().contains("PM")){
//            return ResponseEntity.badRequest().body("KHÔNG ĐƯỢC ĐĂT HÀNG LÚC NÀY");
//        }
//        if (LocalDateTime.now().plus(1, ChronoUnit.HOURS).isAfter(finishDatetime)){
//            System.out.println("ngày nhận:"+finishDatetime);
//            return ResponseEntity.badRequest().body("KHÔNG ĐƯỢC ĐẶT HÀNG LÚC NÀY");
//        }
        try {
           return ResponseEntity.ok(new Response<>(true, ErrorCode.SUCCESS,"", billService.addBill(billRequest,username), username));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,ErrorCode.BAD_REQUEST,e.getMessage(),null, username));
        }
    }

    @Operation(summary = "lấy ra bill phía người dùng")
    @RequestMapping(value = "get-bill",method = RequestMethod.POST)
    public ResponseEntity getBill(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) OrderStatus orderStatus, HttpServletRequest httpServletRequest){
        String header= httpServletRequest.getHeader("Authorization");
        String username = jwtService.getUsernameFromToken(header.substring(7));
        return ResponseEntity.ok(new Response(true,"", ErrorCode.SUCCESS,billService.getBillUser(pageIndex,pageSize,orderStatus,username)));
    }

    @RequestMapping(value = "cancel-bill",method = RequestMethod.PUT)
    public ResponseEntity cancelBill(@RequestParam Integer id,HttpServletRequest request){
        String username = jwtService.getUsernameFromRequest(request);
        try {
            billService.cancelBill(id,username);
            return ResponseEntity.ok("HỦY THÀNH CÔNG");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
