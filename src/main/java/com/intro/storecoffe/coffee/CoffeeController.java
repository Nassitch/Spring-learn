package com.intro.storecoffe.coffee;

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
    public ResponseEntity<List<CoffeeDTO>> getAll() {
        List<Coffee> coffees = service.getAll();
        List<CoffeeDTO> coffeeDTOS = coffees.stream().map(CoffeeDTO::mapFromEntity).toList();
        return new ResponseEntity<>(coffeeDTOS, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Coffee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Coffee> postCoffee(@RequestBody Coffee newCoffee) {
        Coffee createdCoffee = service.postCoffee(newCoffee);
        return new ResponseEntity<>(createdCoffee, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Coffee> putById(@RequestBody Coffee coffee, @PathVariable Long id) {
        try {
            Coffee updatedCoffee = service.putById(coffee, id);
            return new ResponseEntity<>(updatedCoffee, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteCoffee(@PathVariable("id") Long id) {
        try {
            String deletedId = service.deleteCoffee(id);
            return new ResponseEntity<>(deletedId, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            String errorMsg = "This id: " + id + " is not found.";
            return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
        }
    }
}
