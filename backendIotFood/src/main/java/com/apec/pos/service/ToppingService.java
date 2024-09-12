package com.apec.pos.service;

import com.apec.pos.dto.ToppingDTO.ToppingResponse;
import com.apec.pos.dto.ToppingDTO.Item;
import com.apec.pos.dto.ToppingDTO.ToppingRequest;
import com.apec.pos.entity.ToppingEntity;
import com.apec.pos.repository.ToppingRepository;
import com.apec.pos.service.serviceInterface.ToppingInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ToppingService extends BaseService<ToppingRepository, ToppingEntity, Integer> implements ToppingInterface {

    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    ToppingRepository getRepository() {
        return toppingRepository;
    }

    @Override
    public ToppingResponse addTopping(ToppingRequest toppingRequest) {
        Gson gson = new Gson();
        ToppingEntity toppingEntity = ToppingEntity.builder()
                .restaurantEntityId(toppingRequest.getResId())
                .title(toppingRequest.getTitle())
                .requi(toppingRequest.getRequire())
                .items(gson.toJson(toppingRequest.getItem()))
                .build();
        toppingEntity = toppingRepository.insert(toppingEntity);


        List<Item> itemList = gson.fromJson(toppingEntity.getItems(),new TypeToken<List<Item>>(){}.getType());
//        System.out.println(itemList);

        ToppingResponse toppingResponse = ToppingResponse.builder()
                .id(toppingEntity.getId())
                .title(toppingEntity.getTitle())
                .itemList(itemList)
                .build();
        return toppingResponse;
    }

    @Override
    public ToppingResponse updateTopping(ToppingRequest toppingRequest) {
        Gson gson = new Gson();

        ToppingEntity toppingEntity = toppingRepository.findOne(toppingRequest.getToppingId());
        toppingEntity = ToppingEntity.builder()
                .items(toppingRequest.getItem() !=null ? gson.toJson(toppingRequest.getItem()):toppingEntity.getItems())
                .title(toppingRequest.getTitle() != null ? toppingRequest.getTitle() : toppingEntity.getTitle())
                .requi(toppingRequest.getRequire() !=null ? toppingRequest.getRequire() : toppingEntity.getRequi())
                .restaurantEntityId(toppingRequest.getResId() != null ? toppingRequest.getResId() : toppingEntity.getRestaurantEntityId())
                .build();
        toppingRepository.update(toppingEntity);

        return null;
    }

    @Override
    public void deleteTopping(Set<Integer> ids) {
        for (Integer x : ids
        ) {
            toppingRepository.delete(x);
        }
    }
}
