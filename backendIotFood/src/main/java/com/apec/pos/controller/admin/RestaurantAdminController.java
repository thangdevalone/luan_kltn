package com.apec.pos.controller.admin;

import java.util.Set;

import com.apec.pos.dto.restaurantDto.ResRecommnedRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.dto.restaurantDto.ResRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class RestaurantAdminController {

    @Autowired
    private RestaurantService restaurantService;

    @Operation(description = "Thêm nhà hàng mới.\n\nCác trường không bắt buộc, bạn có thể nhập theo ý muốn.\n\nNếu không nhập giá trị cho một trường nào đó, giá trị null sẽ được thêm vào cơ sở dữ liệu.\n\nCác thông tin bổ sung:\n\n- id (không nhập): Mã nhà hàng (ID) sẽ được tạo tự động bởi hệ thống, bạn không cần phải nhập giá trị cho trường này.\n- \"restaurantName\" <=> \"tên nhà hàng\": Tên của nhà hàng.\n- \"address\" <=> Địa chỉ quán: Địa chỉ của nhà hàng.\n- \"distance\" <=> Khoảng cách từ trường đến quán: Khoảng cách từ trường đến nhà hàng.\n- \"phoneNumber\" <=> Số điện thoại của quán: Số điện thoại liên hệ của nhà hàng.\n- \"foodEntities\" <=> không nhập",
            summary = "Thêm nhà hàng mới")
    @RequestMapping(value = "add-res", method = RequestMethod.POST, consumes = "multipart/form-data")
    public Response addRestaurant(@ModelAttribute ResRequest request) {
        return new Response(true, "thêm thành công", restaurantService.addRestaurant(request));
    }

    @Operation(summary = "tìm kiếm của hàng theo tên")
    @RequestMapping(value = "search-res", method = RequestMethod.POST)
    public ResponseEntity searchRes(@RequestParam(required = false) String key) {
        return ResponseEntity.ok(new Response<>(true, "", ErrorCode.SUCCESS, restaurantService.searchRes(key)));
    }

    @RequestMapping(value = "update-res", method = RequestMethod.PUT, consumes = "multipart/form-data")
    public ResponseEntity updateRes(@ModelAttribute ResRequest request) {
        ResRecommnedRespon resRecommnedRespon = restaurantService.updateRes(request);
        if (resRecommnedRespon==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,"không tồn tại",ErrorCode.BAD_REQUEST));
        }
        return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, resRecommnedRespon));
    }

    @RequestMapping(value = "delete-res", method = RequestMethod.POST)
    @Operation(summary = "xoa cua hang")
    public ResponseEntity deleteRes(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(new Response(true, "", ErrorCode.SUCCESS, restaurantService.deleteRes(ids)));
    }

    @RequestMapping(value = "/paging-res", method = RequestMethod.POST)
    public ResponseEntity pagingRes(@RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return ResponseEntity.ok(new Response(true, "", restaurantService.paging(pageSize, pageIndex)));
    }

    @RequestMapping(value = "/get-detail-res",method = RequestMethod.POST)
    public ResponseEntity getDetailResAdmin(@RequestParam Integer id){
        ResRecommnedRespon resRecommnedRespon= restaurantService.getDetailResAdmin(id);
        if (resRecommnedRespon==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,"Cửa hàng không tồn tại",ErrorCode.BAD_REQUEST));
        }
        return ResponseEntity.ok(new Response<>(true,"",resRecommnedRespon));
    }
}
