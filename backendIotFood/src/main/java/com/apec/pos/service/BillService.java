package com.apec.pos.service;


import com.apec.pos.dto.FoodDto.BillFoodRequest;
import com.apec.pos.dto.ToppingDTO.Item;
import com.apec.pos.dto.accountDto.LoginResponDto;
import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.dto.billDTO.BillResponse;
import com.apec.pos.dto.billDTO.BillResponsePage;
import com.apec.pos.dto.billDTO.FoodResponseBill;
import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.dto.voucherDTO.VoucherResponseBill;
import com.apec.pos.entity.*;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.repository.*;
import com.apec.pos.service.serviceInterface.BillInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twilio.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apec.pos.PosApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BillService extends BaseService<BillRepository, BillEntity, Integer> implements BillInterface {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private FoodRepository foodRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private VoucherReposioty voucherReposioty;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    BillRepository getRepository() {
        // TODO Auto-generated method stub
        return billRepository;
    }

    @Override
    public List<VoucherEntity> addBill(BillRequest billRequest,String username) throws Exception {

        Gson gson = new Gson();
       if (billRequest.getCodeVoucher()!=null){
           if (!handleVoucher(billRequest.getCodeVoucher())){
               throw new Exception("HẾT VOUCHER RỒI!!!!");
           }
       }

        BillEntity result = BillEntity.builder()
                .orderStatus(OrderStatus.PENDING)
                .totalAmount(billRequest.getTotalAmount())
                .orderBy(username)
                .shipFee(billRequest.getShipFee())
                .code(billRequest.getCodeVoucher())
                .note(billRequest.getNote())
//                .finishTime(billRequest.getFinishTime())
                .accountEntityId(accountRepository.findByUsername(username).getId())
                .build()
                ;
        result = billRepository.insert(result);
        List<BillDetailEntity> billDetailEntities = new ArrayList<>();
        for (BillFoodRequest x: billRequest.getBillFoodRequests()
        ) {
            BillDetailEntity temp = BillDetailEntity.builder()
                    .billEntityId(result.getId())
                    .foodEntityId(x.getFoodId())
                    .quantity(x.getQuantity())
                    .item(gson.toJson(x.getItemList()))
                    .build();
            billDetailEntities.add(temp);
        }
        result.setBillDetailEntities(billDetailEntities);
        billRepository.update(result);
        return voucherReposioty.findAll();
    }

    public boolean handleVoucher(String code){
        VoucherEntity voucherEntity = voucherReposioty.findVoucherByCode(code);
        if (voucherEntity.getQuantity()-1<0){
            return false;
        }
        else {
            voucherEntity.setQuantity(voucherEntity.getQuantity()-1);
            voucherReposioty.update(voucherEntity);
            return true;
        }
    }

    @Override
    public BillEntity updateBill(OrderStatus orderStatus, Integer id) {
        BillEntity billEntity = billRepository.findOne(id);
        if (orderStatus == OrderStatus.DELIVERED) {
            billEntity.setOrderStatus(orderStatus);
            billEntity.setFinishDate(new Date());
            List<BillDetailEntity> billDetailEntities = billEntity.getBillDetailEntities();
            for (BillDetailEntity x:billDetailEntities
                 ) {
                addQuantity(x.getQuantity(),x.getFoodEntityId());
            }
        } else {
            billEntity.setOrderStatus(orderStatus);
        }
        return billRepository.update(billEntity);
    }

    @Override
    public BillResponsePage getBill(int pageIndex, int pageSize, OrderStatus orderStatus) {
        Gson gson = new Gson();
        //tao pageRequest
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);

        List<BillEntity> billEntities = billRepository.pagingBill(pageRequest,orderStatus);
        List<BillResponse> result = new ArrayList<>();
        for (BillEntity x:billEntities
              ) {
            //tao LIST FOOD CHO TRA VE CHO BILL
            List<FoodResponseBill> foodResponseBills = new ArrayList<>();
            List<BillDetailEntity> billDetailEntities = x.getBillDetailEntities();
            for (BillDetailEntity y:billDetailEntities
                 ) {
                //tim food
                FoodEntity foodEntity = y.getFoodEntity();
                if (foodEntity==null){
                    break;
                }
                FoodResponseBill foodResponseBill = FoodResponseBill.builder()
                        .foodId(y.getFoodEntityId())
                        .nameRes(foodEntity.getRestaurantEntity().getRestaurantName())
                        .resId(foodEntity.getRestaurantEntityId())
                        .quantity(y.getQuantity())
                        .nameFood(foodEntity.getFoodName())
                        .priceFood(foodEntity.getPrice())
                        .itemList(gson.fromJson(y.getItem(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                foodResponseBills.add(foodResponseBill);
            }
            VoucherEntity voucherEntity = voucherReposioty.findVoucherByCode(x.getCode());
            VoucherResponseBill voucherResponseBill = null;
            if (voucherEntity!=null){
                voucherResponseBill = new VoucherResponseBill(voucherEntity.getCode(),voucherEntity.getDiscount(),voucherEntity.getExpired(),voucherEntity.getCreateDate());
            }
            // tao BillRespone de tra ve
            BillResponse billResponse = BillResponse.builder()
                    .createAt(x.getCreateDate())
                    .nameRestaurant(x.getNameRes())
                    .orderStatus(x.getOrderStatus())
                    .foodResponseBills(foodResponseBills)
                    .finishTime(x.getFinishTime())
                    .shipFee(x.getShipFee())
                    .note(x.getNote())
                    .finishTime(x.getFinishTime())
                    .accountId(x.getAccountEntityId())
                    .voucherResponseBill(voucherResponseBill)
                    .totalAmount((int) x.getTotalAmount())
                    .id(x.getId())
                    .build();
            result.add(billResponse);
        }

        return new BillResponsePage ((int) billRepository.countBill(null,orderStatus), result);
    }

    @Override
    public BillResponsePage getBillUser(int pageIndex, int pageSize, OrderStatus orderStatus,String username) {
        //tao pageRequest
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);

        Gson gson = new Gson();

        //tim user hien tai
        AccountEntity accountEntity = accountRepository.findByUsername(username);

        List<BillEntity> billEntities = billRepository.pagingUserBill(pageRequest,orderStatus,accountEntity.getId());
        List<BillResponse> result = new ArrayList<>();
        for (BillEntity x:billEntities
        ) {
            //tao LIST FOOD CHO TRA VE CHO BILL
            List<FoodResponseBill> foodResponseBills = new ArrayList<>();
            List<BillDetailEntity> billDetailEntities = x.getBillDetailEntities();
            for (BillDetailEntity y:billDetailEntities
            ) {
                //tim food
                FoodEntity foodEntity = y.getFoodEntity();
                if (foodEntity==null){
                    break;
                }
                FoodResponseBill foodResponseBill = FoodResponseBill.builder()
                        .foodId(y.getFoodEntityId())
                        .nameRes(foodEntity.getRestaurantEntity().getRestaurantName())
                        .resId(foodEntity.getRestaurantEntityId())
                        .quantity(y.getQuantity())
                        .nameFood(foodEntity.getFoodName())
                        .priceFood(foodEntity.getPrice())
                        .itemList(gson.fromJson(y.getItem(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                foodResponseBills.add(foodResponseBill);
            }
            VoucherEntity voucherEntity = voucherReposioty.findVoucherByCode(x.getCode());
            VoucherResponseBill voucherResponseBill = null;
            if (voucherEntity!=null){
                 voucherResponseBill = new VoucherResponseBill(voucherEntity.getCode(),voucherEntity.getDiscount(),voucherEntity.getExpired(),voucherEntity.getCreateDate());
            }
            // tao BillRespone de tra ve
            BillResponse billResponse = BillResponse.builder()
                    .createAt(x.getCreateDate())
                    .nameRestaurant(x.getNameRes())
                    .orderStatus(x.getOrderStatus())
                    .foodResponseBills(foodResponseBills)
                    .finishTime(x.getFinishTime())
                    .shipFee(x.getShipFee())
                    .accountId(x.getAccountEntityId())
                    .totalAmount((int) x.getTotalAmount())
                    .voucherResponseBill(voucherResponseBill)
                    .note(x.getNote())
                    .id(x.getId())
                    .build();
            result.add(billResponse);
        }

        return new BillResponsePage ((int) billRepository.countBill(accountEntity.getId(),orderStatus), result);
    }

    @Override
    public BillResponse getDetailBill(Integer id) {
        BillEntity x = billRepository.findOne(id);
        List<BillDetailEntity> billDetailEntities = x.getBillDetailEntities();
        List<FoodResponseBill> foodResponseBills = createFoodResponse(billDetailEntities);
        VoucherResponseBill voucherResponseBill = createVoucherResponseBill(x.getCode());
        LoginResponDto loginResponDto = createUser(x.getAccountEntityId());
        BillResponse billResponse = BillResponse.builder()
                .createAt(x.getCreateDate())
                .nameRestaurant(x.getNameRes())
                .orderStatus(x.getOrderStatus())
                .foodResponseBills(foodResponseBills)
                .finishTime(x.getFinishTime())
                .shipFee(x.getShipFee())
                .accountId(x.getAccountEntityId())
                .totalAmount((int) x.getTotalAmount())
                .voucherResponseBill(voucherResponseBill)
                .note(x.getNote())
                .id(x.getId())
                .user(loginResponDto)
                .build();
        return billResponse;
    }

    public void cancelBill(Integer id,String username){
        BillEntity billEntity = billRepository.findOne(id);
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if (billEntity.getAccountEntityId().equals(accountEntity.getId())&&billEntity.getOrderStatus().equals(OrderStatus.PENDING)){
            billEntity.setOrderStatus(OrderStatus.CANCELED);
            billRepository.update(billEntity);
        }
        else {
            throw new RuntimeException("HỦY ĐƠN KHÔNG THÀNH CÔNG");
        }
    }

    private LoginResponDto createUser(Integer id){
        AccountEntity accountEntity = accountRepository.findOne(id);
        LoginResponDto loginResponDto = LoginResponDto.builder()
                .imgUser(accountEntity.getImgUser())
                .sdt(accountEntity.getSdt())
                .msv(accountEntity.getUsername())
                .email(accountEntity.getEmail())
                .build();
        return loginResponDto;
    }
    private List<FoodResponseBill> createFoodResponse(List<BillDetailEntity> billDetailEntities){
        Gson gson = new Gson();
        List<FoodResponseBill> foodResponseBills = new ArrayList<>();
        for (BillDetailEntity y:
             billDetailEntities) {
            //tim food
            FoodEntity foodEntity = y.getFoodEntity();
            RestaurantEntity restaurantEntity = foodEntity.getRestaurantEntity();
            if (foodEntity==null){
                break;
            }

            FoodResponseBill foodResponseBill = FoodResponseBill.builder()
                    .foodId(y.getFoodEntityId())
                    .nameRes(restaurantEntity.getRestaurantName())
                    .resId(restaurantEntity.getId())
                    .address(restaurantEntity.getAddress())
                    .quantity(y.getQuantity())
                    .nameFood(foodEntity.getFoodName())
                    .priceFood(foodEntity.getPrice())
                    .itemList(gson.fromJson(y.getItem(),new TypeToken<List<Item>>(){}.getType()))
                    .build();
            foodResponseBills.add(foodResponseBill);
        }
        return foodResponseBills;
    }

    private VoucherResponseBill createVoucherResponseBill(String code){
        VoucherEntity voucherEntity = voucherReposioty.findVoucherByCode(code);
        VoucherResponseBill voucherResponseBill = null;
        if (voucherEntity!=null){
            voucherResponseBill = new VoucherResponseBill(voucherEntity.getCode(),voucherEntity.getDiscount(),voucherEntity.getExpired(),voucherEntity.getCreateDate());
        }
        return voucherResponseBill;
    }

    private void addQuantity(int quantity,int foodId){
        int resId = foodRepository.findOne(foodId).getRestaurantEntityId() ;
        restaurantRepository.updateQuantity(quantity,resId);
        foodRepository.addQuantity(quantity,foodId);
    }
}
