package com.intro.storecoffe.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get/all")
    public List<Store> getAll() {
        return storeService.getAll();
    }

    @GetMapping("/get/{id}")
    public Store getStoreById(@PathVariable("id") Long id) {
        return storeService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Store> createStore(@RequestBody Store newStore) {
        Store storeCreated = storeService.post(newStore);
        return new ResponseEntity<>(storeCreated, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Store> editStore(@RequestBody Store store, @PathVariable("id") Long id) {
        try {
            Store updatedStore = storeService.put(store, id);
            return new ResponseEntity<>(updatedStore, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeStore(@PathVariable("id") Long id) {
        try {
            String deleteStore = storeService.delete(id);
            return new ResponseEntity<>(deleteStore, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            String errorMsg = "This id: '" + id + "' was not found.";
            return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
        }
    }
}
