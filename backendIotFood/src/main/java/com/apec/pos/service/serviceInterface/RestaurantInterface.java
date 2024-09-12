package com.apec.pos.service.serviceInterface;

import java.util.List;
import java.util.Set;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.restaurantDto.ResRecommnedRespon;
import com.apec.pos.dto.restaurantDto.ResRequest;
import com.apec.pos.dto.restaurantDto.ResponsePaging;
import com.apec.pos.dto.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;

public interface RestaurantInterface {
    public RestaurantEntity addRestaurant(ResRequest request);

    public List<ResRecommnedRespon> getRecommendRes();

    public ResRecommnedRespon getResdetail(Integer id);

    public List<SearchForm> searchRes(String key);

    public ResRecommnedRespon updateRes(ResRequest request);

    public Set<Integer> deleteRes(Set<Integer> ids);

    public ResponsePaging paging(Integer pageSize, Integer pageIndex);

    public List<FoodRecommendDto> getFoodOfRes(Integer id);

    public ResRecommnedRespon getDetailResAdmin(Integer id);
}
