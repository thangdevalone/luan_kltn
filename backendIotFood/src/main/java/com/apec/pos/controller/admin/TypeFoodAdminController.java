package com.apec.pos.controller.admin;

import java.util.Set;

import com.apec.pos.dto.TypeDto.TypefoodResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.dto.TypeDto.UpdateTypeRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.TypeFoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class TypeFoodAdminController {

    @Autowired
    private TypeFoodService typeFoodService;

    //thêm
    @Operation(description = "", summary = "thêm loại món ăn mới")
    @RequestMapping(value = "add-type", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addTypeFood(@ModelAttribute UpdateTypeRequest updateTypeRequest) {
        return ResponseEntity.ok(new Response<>(true, "thêm thành công", ErrorCode.SUCCESS, typeFoodService.addTypeFood(updateTypeRequest)));
    }

    //sửa
    @Operation(description = "", summary = "sửa loại món ăn")
    @RequestMapping(value = "update-type", method = RequestMethod.PUT, consumes = "multipart/form-data")
    public ResponseEntity updateTypeFood(@ModelAttribute UpdateTypeRequest updateTypeRequest) {
        TypefoodResponseData typefoodResponseData = typeFoodService.updateTypeFood(updateTypeRequest);
        if (typefoodResponseData==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,"không tồn tại id này",typefoodResponseData));
        }
        return ResponseEntity.ok(new Response<>(true, "sửa thành công", ErrorCode.SUCCESS));
    }

    @Operation(description = "", summary = "xóa vĩnh viễn type")
    @RequestMapping(value = "update-status", method = RequestMethod.DELETE)
    public ResponseEntity deleteType(@RequestParam Integer id) {
        return ResponseEntity.ok(new Response<>(true, "xóa thành công", ErrorCode.SUCCESS, typeFoodService.deleteType(id)));
    }

    @Operation(summary = "lấy ra tất cả typeFood theo trang", description = "pageIndex nhận vào tính từ 0")
    @RequestMapping(value = "paging-type-admin", method = RequestMethod.POST)
    public ResponseEntity pagingType(@RequestParam int pageSize, @RequestParam int pageIndex) {
        return ResponseEntity.ok(new Response(true, "trang" + pageIndex, ErrorCode.SUCCESS, typeFoodService.paging(pageSize, pageIndex)));
    }

    @RequestMapping(value = "delete-type", method = RequestMethod.POST)
    @Operation(summary = "xóa nhiều type")
    public ResponseEntity MultiDelete(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(new Response(true, "", typeFoodService.MultiDelete(ids)));
    }

    @RequestMapping(value = "search-type", method = RequestMethod.POST)
    @Operation(summary = "tìm tiếm type")
    public ResponseEntity searchType(@RequestParam(required = false) String key) {
        return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, typeFoodService.searchType(key)));
    }
}
