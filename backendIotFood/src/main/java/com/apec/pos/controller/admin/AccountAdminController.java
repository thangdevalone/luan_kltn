package com.apec.pos.controller.admin;

import com.apec.pos.dto.accountDto.UpdateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apec.pos.dto.accountDto.RegisterRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.io.IOException;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "ADMIN")
public class AccountAdminController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "phân trang người dùng")
    @RequestMapping(value = "paging-user", method = RequestMethod.POST)
    public ResponseEntity pagingAccount(@RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, accountService.paging(pageSize, pageIndex)));
    }

    @RequestMapping(value = "MANAGER/add-employee", method = RequestMethod.POST)
    @Operation(summary = "thêm nhân viên")
    public ResponseEntity addEmployee(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(new Response<>(true, "", accountService.addEmployee(registerRequest)));
    }

    @RequestMapping(value = "MANAGER/update-employee", method = RequestMethod.POST, consumes = "multipart/form-data")
    @Operation(summary = "sửa nhân viên")
    public ResponseEntity updateEmployee(@ModelAttribute UpdateAccountRequest updateAccountRequest) throws IOException {
        return ResponseEntity.ok(new Response<>(true, "", accountService.updateEmployee(updateAccountRequest)));
    }

    @RequestMapping(value = "MANAGER/paging-employee",method = RequestMethod.POST)
    @Operation(summary = "phân trang nhân viên")
    public ResponseEntity pagingEmployee(@RequestParam Integer pageSize,@RequestParam Integer pageIndex){
        return ResponseEntity.ok(new Response(true,"",ErrorCode.SUCCESS,accountService.pagingEmployee(pageSize,pageIndex)));
    }
}
