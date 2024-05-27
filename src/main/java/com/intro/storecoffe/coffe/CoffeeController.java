package com.intro.storecoffe.coffe;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<Coffee>> getAll() {
        List<Coffee> coffees = service.getAll();
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Optional<Coffee> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Coffee postCoffee(@RequestBody Coffee newCoffee) {
        return service.postCoffee(newCoffee);
    }

    @PutMapping("/edit/{id}")
    public Coffee putById(Coffee coffee, Long id) {
        return service.putById(coffee, id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCoffee(@PathVariable("id") Long id) {
        service.deleteCoffee(id);
    }
}
