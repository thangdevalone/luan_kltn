package com.apec.pos.controller.admin;

import com.apec.pos.dto.ToppingDTO.ToppingRequest;
import com.apec.pos.response.Response;
import com.apec.pos.service.ToppingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class ToppingAdminController {

    @Autowired
    private ToppingService toppingService;

    @Operation(summary = "thêm topping", description = "không cần truyền id")
    @RequestMapping(value = "add-topping", method = RequestMethod.POST)
    public ResponseEntity addTopping(@RequestBody ToppingRequest toppingRequest) {
        return ResponseEntity.ok(new Response(true, "", toppingService.addTopping(toppingRequest)));
    }
//
//    @Operation(summary = "sửa topping")
//    @RequestMapping(value = "update-topping", method = RequestMethod.PUT)
//    public ResponseEntity updateTopping(@RequestBody ToppingRequest toppingRequest) {
//        return ResponseEntity.ok((new Response(true, "", toppingService.updateTopping(toppingRequest))));
//    }

    @Operation(summary = "xóa topping")
    @RequestMapping(value = "delete-topping", method = RequestMethod.POST)
    public ResponseEntity deleteTopping(@RequestBody Set<Integer> ids) {
        toppingService.deleteTopping(ids);
        return ResponseEntity.ok(new Response(true, ""));
    }
}
