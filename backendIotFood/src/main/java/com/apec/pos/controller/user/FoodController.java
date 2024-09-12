package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "user")
@SecurityRequirement(name = "bearerAuth")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Operation(summary = "phân trang sản phẩm", description = "pageIndex nhận vào tính từ 0")
    @RequestMapping(value = "/paging-food-admin", method = RequestMethod.POST)
    public ResponseEntity pagingFood(@RequestParam int pageSize, @RequestParam int pageIndex) {
        return ResponseEntity.ok(new Response(true, "trang" + pageIndex, ErrorCode.SUCCESS, foodService.paging(pageSize, pageIndex)));
    }

}
