package com.intro.storecoffe.coffee;

import com.intro.storecoffe.Errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public List<Coffee> getAll() {
        return coffeeRepository.findAll();
    }

    public Coffee getById(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
    }

    public Coffee postCoffee(Coffee newCoffee) {
        return coffeeRepository.save(newCoffee);
    }

    public Coffee putById(Coffee coffee, Long id) {
        Optional<Coffee> coffeeFind = coffeeRepository.findById(id);

        if (coffeeFind.isPresent()) {
            Coffee existingCoffee = coffeeFind.get();
            existingCoffee.setName(coffee.getName());
            existingCoffee.setPrice(coffee.getPrice());
            return coffeeRepository.save(existingCoffee);
        } else {
            throw new IllegalArgumentException("Coffee not found with id: " + id);
        }
    }

    public String deleteCoffee(Long id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return "id: " + id;
        } else {
            throw new IllegalArgumentException("Coffee not found with id: " + id);
        }
    }
}
