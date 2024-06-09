package com.example.demo.controllers;


import com.example.demo.entity.SavedSearch;
import com.example.demo.entity.SavedSearchDTO;
import com.example.demo.service.SavedSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("saved-searches")
public class SavedSearchController {


    private final SavedSearchService savedSearchService;
    public SavedSearchController(SavedSearchService savedSearchService) {
        this.savedSearchService = savedSearchService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<SavedSearch> getSavedSearches() {
        return savedSearchService.getAllSavedSearches();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Long> createSavedSearch(@RequestBody SavedSearchDTO savedSearchDTO) {
       return ResponseEntity.ok(savedSearchService.saveSavedSearch(savedSearchDTO));
    }


}
