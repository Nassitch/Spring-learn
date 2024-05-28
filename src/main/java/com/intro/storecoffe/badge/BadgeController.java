package com.intro.storecoffe.badge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/badge")
public class BadgeController {

    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Badge>> getAllBadges() {
        List<Badge> badges = badgeService.getAll();
        return new ResponseEntity<>(badges, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Badge getBageById(@PathVariable("id") Long id) {
        return badgeService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Badge> createBadge(@RequestBody Badge badge) {
        Badge newBadge = badgeService.post(badge);
        return new ResponseEntity<>(newBadge, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Badge> editBadge(@RequestBody Badge badge, @PathVariable Long id) {
        try {
            Badge updateBadge = badgeService.put(badge, id);
            return new ResponseEntity<>(updateBadge, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeBadge(@PathVariable("id") Long id) {
        try {
            String deleteBadge = badgeService.delete(id);
            return new ResponseEntity<>(deleteBadge, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            String errorMsg = "This id: '" + id + "' was not found.";
            return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
        }
    }
}
