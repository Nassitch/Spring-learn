package com.intro.storecoffe.badge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intro.storecoffe.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive = false;

    public Badge(Long id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public boolean getActive() {
        return this.isActive;
    }

    @OneToOne(mappedBy = "badge")
    @JsonIgnoreProperties("badge")
    private Employee employee;
}
