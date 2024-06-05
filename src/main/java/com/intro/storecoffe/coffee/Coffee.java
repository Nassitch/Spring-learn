package com.intro.storecoffe.coffee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intro.storecoffe.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;

    public Coffee(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @ManyToMany(mappedBy = "coffees")
    private List<Store> stores = new ArrayList<>();
}
