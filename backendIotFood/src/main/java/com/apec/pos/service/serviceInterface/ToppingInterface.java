package com.apec.pos.service.serviceInterface;


import com.apec.pos.dto.ToppingDTO.ToppingResponse;
import com.apec.pos.dto.ToppingDTO.ToppingRequest;


import java.util.Set;

public interface ToppingInterface {
    public ToppingResponse addTopping(ToppingRequest toppingRequest);

    public ToppingResponse updateTopping(ToppingRequest toppingRequest);

    public void deleteTopping(Set<Integer> ids);
}
