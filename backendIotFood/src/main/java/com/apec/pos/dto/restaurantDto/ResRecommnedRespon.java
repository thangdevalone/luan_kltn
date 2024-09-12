package com.apec.pos.dto.restaurantDto;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.ToppingDTO.Item;
import com.apec.pos.entity.ToppingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.apec.pos.dto.ToppingDTO.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResRecommnedRespon {

    private Integer id;
    private String restaurantName;
    private Integer quantitySold;
    private String timeStart;
    private String timeClose;
    private Double distance;
    private String address;
    private String phoneNumber;
    private String imgRes;
    private String detail;
    private Double star;
    private List<ToppingResponse> toppingEntityList;
    private List<FoodRecommendDto> foodRecommendDtos;


    public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, String timeStart, String timeClose, Double distance, String address, String phoneNumber, String imgRes) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.quantitySold = quantitySold;
        this.timeStart = timeStart;
        this.timeClose = timeClose;
        this.distance = distance;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.imgRes = imgRes;
    }

    public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, Double distance, String address, String phoneNumber, String imgRes) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.quantitySold = quantitySold;
        this.distance = distance;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.imgRes = imgRes;
    }

    //getDetailResAdmin
    public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, String timeStart, String timeClose, Double distance, String address, String phoneNumber, String imgRes, String detail, Double star) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.quantitySold = quantitySold;
        this.timeStart = timeStart;
        this.timeClose = timeClose;
        this.distance = distance;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.imgRes = imgRes;
        this.detail = detail;
        this.star = star;
    }
}
