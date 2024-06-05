package com.intro.storecoffe.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intro.storecoffe.coffee.Coffee;
import com.intro.storecoffe.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    public Store(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Coffee> coffees = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    @JsonIgnoreProperties("store")
    public List<Employee> employees = new ArrayList<>();
}
