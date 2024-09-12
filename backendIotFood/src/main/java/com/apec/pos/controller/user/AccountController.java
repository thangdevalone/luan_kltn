package com.apec.pos.controller.user;

import com.apec.pos.dto.accountDto.*;
import com.apec.pos.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;
import com.apec.pos.service.JwtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Operation(description = "trả về thông tin người dùng đang đăng nhập, dựa trên token", summary = "lấy ra thông tin người dùng hiện tại")
    @RequestMapping(value = "/get-user-info", method = RequestMethod.GET)
    public ResponseEntity getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        return ResponseEntity.ok(new Response<>(true, "lấy thông tin thành công", accountService.getUserInfo(token)));
    }

    @Operation(summary = "sửa thông người dùng", description = "không cần truyền <b>username</b>, <b>id</b>,tạm thời chưa thể sửa mật khẩu và số điện thoại được")
    @RequestMapping(value = "/update-user-info", method = RequestMethod.PUT, consumes = "multipart/form-data")
    public ResponseEntity updateUserInfo(HttpServletRequest request, @ModelAttribute UpdateRequest updateRequest) throws Exception {
        String username = jwtService.getUsernameFromRequest(request);
        AccountInfoDto accountInfoDto = accountService.updateAccountInfo(updateRequest,username);
        if (accountInfoDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(true, "mật khẩu không hợp lệ", ErrorCode.BAD_REQUEST));
        }
        try {
            return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, accountInfoDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "phân trang người dùng")
    @RequestMapping(value = "paging-user", method = RequestMethod.POST)
    public ResponseEntity pagingAccount(@RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, accountService.paging(pageSize, pageIndex)));
    }

    @RequestMapping(value = "verify-email",method = RequestMethod.POST)
    public ResponseEntity verifyEmail(@RequestParam String email,HttpServletRequest httpServletRequest){
        String username = jwtService.getUsernameFromRequest(httpServletRequest);
        System.out.println(username);
        if (emailSenderService.isExitsEmail(username)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoan này đã xác thực email rồi");
        }

            return ResponseEntity.ok(new Response<>(true,"",ErrorCode.SUCCESS,emailSenderService.sendEmail(email,username)));
    }

    @Operation(summary = "")
    @RequestMapping(value = "validate-otp",method = RequestMethod.POST)
    public ResponseEntity validateOtp(@RequestParam String otp,HttpServletRequest httpServletRequest){
           String username=jwtService.getUsernameFromRequest(httpServletRequest);
                return ResponseEntity.ok(new Response<>(true,"",ErrorCode.SUCCESS,emailSenderService.validateOtpForVerify(otp,username)));
    }
}
 