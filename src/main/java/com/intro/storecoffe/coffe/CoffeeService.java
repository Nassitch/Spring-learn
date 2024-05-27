package com.intro.storecoffe.coffe;
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

    public Optional<Coffee> getById(Long id) {
        return coffeeRepository.findById(id);
    }

    public Coffee postCoffee(Coffee newCoffee) {
        return coffeeRepository.save(newCoffee);
    }

    public Coffee putById(Coffee coffee, Long id) {
        Optional<Coffee> coffeeFind = coffeeRepository.findById(id);

        coffeeFind.setName(coffee.getName());
        coffeeFind.setPrice(coffee.getPrice());

        return coffeeRepository.save(coffeeFind);
    }

    public void deleteCoffee(Long id) {
        coffeeRepository.deleteById(id);
    }
}
