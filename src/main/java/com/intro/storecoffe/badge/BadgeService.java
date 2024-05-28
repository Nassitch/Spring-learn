package com.intro.storecoffe.badge;

import com.intro.storecoffe.Errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public List<Badge> getAll() {
        return badgeRepository.findAll();
    }

    public Badge getById(Long id) {
        return badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This badge id: '" + id + "' was not foound."));
    }

    public Badge post(Badge badge) {
        return badgeRepository.save(badge);
    }

    public Badge put(Badge badge, Long id) {
        Badge badgeToEdit = getById(id);

        badgeToEdit.setActive(badge.getActive());

        return badgeRepository.save(badgeToEdit);
    }

    public String delete(Long id) {
        if (badgeRepository.findById(id).isPresent()) {
            badgeRepository.deleteById(id);
            return "id: " + id;
        } else {
            String errorMsg = "This id: '" + id + "' not founded.";
            throw new ResourceNotFoundException(errorMsg);
        }
    }
}
