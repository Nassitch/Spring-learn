package com.intro.storecoffe.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intro.storecoffe.badge.Badge;
import com.intro.storecoffe.store.Store;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "badge_id")
    @JsonIgnoreProperties("employee")
    private Badge badge;
}
