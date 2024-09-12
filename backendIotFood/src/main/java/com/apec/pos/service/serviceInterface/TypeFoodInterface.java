package com.apec.pos.service.serviceInterface;

import java.util.List;

import java.util.Set;

import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.TypeDto.DetailTypeFood;
import com.apec.pos.dto.TypeDto.TypefoodResponseData;
import com.apec.pos.dto.TypeDto.UpdateTypeRequest;
import com.apec.pos.dto.restaurantDto.SearchForm;
import io.swagger.models.auth.In;

public interface TypeFoodInterface {
    public TypefoodResponseData addTypeFood(UpdateTypeRequest updateTypeRequest);

    public TypefoodResponseData updateTypeFood(UpdateTypeRequest updateTypeRequest);

    public TypefoodResponseData updateStatusType(Integer id, Boolean status);

    public String deleteType(Integer id);

    public Set<Integer> MultiDelete(Set<Integer> ids);

    public List<SearchForm> searchType(String key);

    public DetailTypeFood getDetailType(Integer id);

    public DetailTypeFood getDetailFoodAdmin(Integer id);
}
