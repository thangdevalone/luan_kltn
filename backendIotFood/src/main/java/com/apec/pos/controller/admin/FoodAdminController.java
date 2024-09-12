package com.apec.pos.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.apec.pos.dto.FoodDto.AddMultipartFood;
import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.FoodDto.UpdateFood;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.apec.pos.dto.FoodDto.AddFoodRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class FoodAdminController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private ObjectMapper objectMapper;

    @Operation(summary = "thêm food", description = "dsadsadas")
    @RequestMapping(value = "add-food", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addFood(
            @ModelAttribute AddFoodRequest addFoodRequest,BindingResult bindingResult)
    {

   return ResponseEntity.ok(new Response(true, "Thành công", ErrorCode.SUCCESS, foodService.addFood(addFoodRequest)));
    }

    @RequestMapping(value = "update-food", method = RequestMethod.PUT, consumes = "multipart/form-data")
    @Operation(summary = "sửa món ăn", description = "")
    public ResponseEntity updateFood(@ModelAttribute UpdateFood addFoodRequest) throws IOException {
        FoodRecommendDto foodRecommendDto = foodService.updateFood(addFoodRequest);
        if (foodRecommendDto==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,"món ăn không tồn tại",ErrorCode.BAD_REQUEST));
        }
        return ResponseEntity.ok(new Response<>(true,"",foodRecommendDto));
    }

    @Operation(summary = "phân trang sản phẩm", description = "pageIndex nhận vào tính từ 0")
    @RequestMapping(value = "/paging-food-admin", method = RequestMethod.POST)
    public ResponseEntity pagingFood(@RequestParam int pageSize, @RequestParam int pageIndex) {
        return ResponseEntity.ok(new Response(true, "trang" + pageIndex, ErrorCode.SUCCESS, foodService.paging(pageSize, pageIndex)));
    }

    @Operation(summary = "xoá nhiều sản phẩm")
    @RequestMapping(value = "/delete-food", method = RequestMethod.POST)
    public ResponseEntity multiDelete(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(new Response(true, "", foodService.MuiltiDelete(ids)));
    }


    @Operation(summary = "thêm nhiều món ăn",description = "không cần truyền id")
    @RequestMapping(value = "add-multi-food",method = RequestMethod.POST)
    public ResponseEntity multiAddFood(@RequestBody List<AddMultipartFood> addFoodRequests) throws IOException {
        foodService.multipartAddFood(addFoodRequests);
        return ResponseEntity.ok(new Response(true,"",ErrorCode.SUCCESS));
    }
}
