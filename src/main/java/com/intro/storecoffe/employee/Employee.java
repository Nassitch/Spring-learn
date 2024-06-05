package com.intro.storecoffe.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intro.storecoffe.store.Store;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private short age;
    private float salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    @JsonIgnoreProperties("employees")
    private Store store;
}
