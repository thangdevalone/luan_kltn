package com.apec.pos.service.serviceInterface;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.apec.pos.dto.FoodDto.AddFoodRequest;
import com.apec.pos.dto.FoodDto.AddMultipartFood;
import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.FoodDto.FoodResponseAdmin;
import com.apec.pos.dto.FoodDto.UpdateFood;
import com.apec.pos.entity.FoodEntity;

public interface FoodInterface {

    public List<FoodRecommendDto> getFoodRecommand();

    public FoodRecommendDto addFood(AddFoodRequest addFoodRequest) throws IOException;

    public List<FoodEntity> findFoodOnType(FoodEntity foodEntity);

    public List<FoodRecommendDto> searchFood(String searchString);

    public FoodRecommendDto getDetailFood(Integer id);

    public FoodResponseAdmin paging(int pageSize, int pageIndex);

    public FoodRecommendDto updateFood(UpdateFood addFoodRequest) throws IOException;

    public String updateStatusFood(Integer id, Boolean status);

    public String deleteFood(Integer id);

    public List<Integer> MuiltiDelete(Set<Integer> ids);

    public void multipartAddFood(List<AddMultipartFood> addFoodRequests) throws IOException;
}
