package com.apec.pos;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.TypeDto.DetailTypeFood;

import com.apec.pos.dto.accountDto.*;
import com.apec.pos.dto.restaurantDto.ResRecommnedRespon;
import com.apec.pos.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.http.HttpStatus;


import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.dto.otpDto.OtpRequestDto;
import com.apec.pos.dto.otpDto.OtpResponseDto;
import com.apec.pos.dto.otpDto.OtpValidationRequestDto;
import com.apec.pos.unitl.Validator;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = "auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private TypeFoodService typeFoodService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private JwtService jwtService;
    @Operation(description = "'username'<=>'mã sinh viên'\n\n 'password'<=>'mật khẩu'",
            summary = "Đăng nhập")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        LoginResponDto loginResponDto = accountService.login(loginRequest);
        if (loginResponDto == null) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response(true, "Tài Khoản Hoặc Mật Khẩu Không Chính Xác", ErrorCode.BAD_REQUEST));
        }
        return ResponseEntity.status(HttpStatus.SC_OK).body(new Response<LoginResponDto>(true, "Đăng nhập thành công", ErrorCode.SUCCESS, loginResponDto));
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity hello() {
       
        return ResponseEntity.ok("hi");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest) {
        if (!Validator.validatePassword(registerRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response<>(false, "Tài khoàn hoặc mật khẩu không hợp lệ"));
        }


        LoginResponDto loginResponDto = accountService.register(registerRequest);
        if (loginResponDto == null) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response(true, "Đăng kí thất bại,tài khoản đã tồn tại", ErrorCode.BAD_REQUEST));
        }

        return ResponseEntity.ok(new Response(true, "Đăng kí thành công", ErrorCode.SUCCESS, loginResponDto));
    }

    @Operation(description = "lấy ra danh sách các món ăn được đề xuất,hiện tại đang là 10 món", summary = "lấy ra các món ăn đề xuất")
    @RequestMapping(value = "get-recommend-food", method = RequestMethod.GET)
    public Response getRecommendFood() {
        return new Response<>(true, "lấy thành công", ErrorCode.SUCCESS, foodService.getFoodRecommand());
    }

    @Operation(summary = "lấy ra các type food")
    @RequestMapping(value = "get-all-type", method = RequestMethod.GET)
    public Response getTypeFood() {
        return new Response<>(true, "lấy ra các loại món ăn", ErrorCode.SUCCESS, typeFoodService.findAll());
    }

    @Operation(summary = "tìm kiếm món ăn theo type,detail,tên món ăn")
    @RequestMapping(value = "search-food", method = RequestMethod.POST)
    public ResponseEntity searchFood(@RequestParam(required = false) String searchString) {
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, foodService.searchFood(searchString)));
    }

    @Operation(summary = "lấy ra detail food", description = "khi bấm vào một món ăn sẽ gọi đến api này")
    @RequestMapping(value = "get-detail-food", method = RequestMethod.POST)
    public ResponseEntity getDetailFood(@RequestParam Integer id) {
        FoodRecommendDto foodRecommendDto = foodService.getDetailFood(id);
        if (foodRecommendDto==null){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body((new Response<>(false,"món ăn không tồn tại")));
        }
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, foodRecommendDto));
    }

    @Operation(summary = "lấy ra danh sách cửa hàng đề xuất")
    @RequestMapping(value = "get-recommend-res", method = RequestMethod.GET)
    public ResponseEntity getRecommendRes() {
        return ResponseEntity.ok(new Response<>(true, "lấy thành công", ErrorCode.SUCCESS, restaurantService.getRecommendRes()));
    }

    @Operation(summary = "lấy ra restaurant detail", description = "quantitySold = 'Số lượng đã bán'\n\n quantityPurchased = 'số lượng đã mua'")
    @RequestMapping(value = "get-detail-res", method = RequestMethod.POST)
    public ResponseEntity getDetailRes(@RequestParam Integer id) {
        ResRecommnedRespon resRecommnedRespon = restaurantService.getResdetail(id);
        if (resRecommnedRespon==null){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body((new Response<>(false,"cửa hàng không tồn tại")));
        }
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, resRecommnedRespon));
    }

    @RequestMapping(value = "/paging-res", method = RequestMethod.POST)
    public ResponseEntity pagingRes(@RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return ResponseEntity.ok(new Response(true, "", restaurantService.paging(pageSize, pageIndex)));
    }

    @RequestMapping(value ="get-detail-type",method= RequestMethod.POST)
    @Operation(summary ="lấy detail type")
    public ResponseEntity getDetailType(@RequestParam Integer id){
        DetailTypeFood detailTypeFood = typeFoodService.getDetailType(id);
        if(detailTypeFood==null){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body((new Response<>(false,"type không tồn tại")));
        }
        return  ResponseEntity.ok(new Response(true,"",ErrorCode.SUCCESS,detailTypeFood));
    }

    @Operation(summary = "phân trang sản phẩm", description = "pageIndex nhận vào tính từ 0")
    @RequestMapping(value = "/paging-food-admin", method = RequestMethod.POST)
    public ResponseEntity pagingAuthFood(@RequestParam int pageSize, @RequestParam int pageIndex) {
        return ResponseEntity.ok(new Response(true, "trang" + pageIndex, ErrorCode.SUCCESS, foodService.paging(pageSize, pageIndex)));
    }

    @Operation(summary = "gửi email để quên mat khẩu")
    @RequestMapping(value = "forgot-pass",method = RequestMethod.POST)
    public ResponseEntity forgotPass(@RequestParam String username){
        try {
            if (emailSenderService.isExitsEmail(username)) {
                return ResponseEntity.ok(new Response<>(true, "", emailSenderService.sendEmailByForget(username)));
            }
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("Không có email xác thực");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(e.getMessage());
        }
    }
    @Operation(summary = "gửi otp để cho việc quên mật khẩu")
    @RequestMapping(value = "validate-otp-forgot-pass",method = RequestMethod.POST)
    public ResponseEntity validateOtpForForget(@RequestBody MailAuth mailAuth){
        return ResponseEntity.ok(new Response<>(true,"",emailSenderService.validateOtpForForgetPass(mailAuth.getOtp(),mailAuth.getUsername())));
    }

    @RequestMapping(value = "change-password",method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestBody PassAndOtp passAndOtp){
        String username = passAndOtp.getUsername();
        try {
            return ResponseEntity.ok(new Response<>(true,"",ErrorCode.SUCCESS,emailSenderService.changePassword(passAndOtp,username)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new Response<>(false,e.getMessage()));
        }
    }
}
