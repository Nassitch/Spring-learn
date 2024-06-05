package com.intro.storecoffe.coffee;

import com.intro.storecoffe.store.Store;

import java.util.List;

public record CoffeeDTO(
        Long id,
        String name,
        Float price,
        List<Long> storeIds
) {

    public static CoffeeDTO mapFromEntity(Coffee coffee) {
        return new CoffeeDTO(
                coffee.getId(),
                coffee.getName(),
                coffee.getPrice(),
                coffee.getStores().stream().map(Store::getId).toList()
        );
    }
}
