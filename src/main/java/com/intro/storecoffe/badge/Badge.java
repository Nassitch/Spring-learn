package com.intro.storecoffe.badge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
@Entity
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
}
