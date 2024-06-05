package com.intro.storecoffe.store;

import com.intro.storecoffe.coffee.Coffee;

import java.util.List;

public record StoreDTO(
        Long id,
        String name,
        String location,
        List<Long> coffeeIds
) {

    public static StoreDTO mapFromEntity(Store store) {
        return new StoreDTO(
                store.getId(),
                store.getName(),
                store.getLocation(),
                store.getCoffees().stream().map(Coffee::getId).toList()
        );
    }
}
