package com.intro.storecoffe.store;

import com.intro.storecoffe.Errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public Store getById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This '" + id + "' was not found."));
    }

    public Store post(Store store) {
        return storeRepository.save(store);
    }

    public Store put(Store store, Long id) {
        Optional<Store> storechecked = storeRepository.findById(id);

        if (storechecked.isPresent()) {
            Store storeFounded = storechecked.get();
            storeFounded.setName(store.getName());
            storeFounded.setLocation(store.getLocation());
            return storeRepository.save(storeFounded);
        } else {
            throw new IllegalArgumentException("This '" + id + "' store not found.");
        }
    }

    public String delete(Long id) {
        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
            return "id: " + id;
        } else {
            throw new IllegalArgumentException("Store not found with id: " + id);
        }
    }
}
