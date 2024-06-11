package com.example.demo.service;


import com.example.demo.entity.*;
import com.example.demo.repository.SavedSearchJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class SavedSearchService {

    private SavedSearchJpaRepository savedSearchJpaRepository;

    public SavedSearchService( SavedSearchJpaRepository savedSearchJpaRepository) {
        this.savedSearchJpaRepository = savedSearchJpaRepository;
    }


    @PostConstruct
    public void init(){
        if(savedSearchJpaRepository.count() == 0){
            SavedSearch search1 = new SavedSearch();
            search1.setName("Programari deschise");
            search1.setFilterKeys(List.of(
                    new FilterKey("status", "CREATED")
            ));
            search1.setSortCriteria(Arrays.asList(
                    new SortCriteria("appointmentDateTime", "asc")
            ));
            search1.setColumnVisibility(List.of(
                    new ColumnVisibility("animalName", true),
                    new ColumnVisibility("doctorName", true),
                    new ColumnVisibility("appointmentDateTime", true),
                    new ColumnVisibility("diagnosis", false),
                    new ColumnVisibility("totalCost", true),
                    new ColumnVisibility("status", true)
            ));
            search1.setUserID(1L);

            SavedSearch search2 = new SavedSearch();
            search2.setName("Programari inchise");
            search2.setFilterKeys(List.of(
                    new FilterKey("status", "COMPLETED")
            ));
            search2.setSortCriteria(List.of(
                    new SortCriteria("appointmentDateTime", "desc")
            ));
            search2.setColumnVisibility(List.of(
                    new ColumnVisibility("animalName", true),
                    new ColumnVisibility("doctorName", true),
                    new ColumnVisibility("appointmentDateTime", true),
                    new ColumnVisibility("diagnosis", false),
                    new ColumnVisibility("totalCost", true),
                    new ColumnVisibility("status", true)
            ));
            search2.setUserID(2L);

            savedSearchJpaRepository.saveAll(List.of(search1, search2));
        }

    }


    public List<SavedSearch> getAllSavedSearches() {
        return savedSearchJpaRepository.findAll();
    }

    public Long saveSavedSearch(SavedSearchDTO savedSearchDTO) {
        SavedSearch savedSearch = new SavedSearch(
                savedSearchDTO.getName(),
                savedSearchDTO.getFilterKeys(),
                savedSearchDTO.getSortCriteria(),
                savedSearchDTO.getColumnVisibility(),
                savedSearchDTO.getUserID(),
                savedSearchDTO.getPageNumber()
        );
        savedSearchJpaRepository.save(savedSearch);
        return savedSearch.getId();

    }
}
