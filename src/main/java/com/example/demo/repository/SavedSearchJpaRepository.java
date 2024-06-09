package com.example.demo.repository;

import com.example.demo.entity.SavedSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedSearchJpaRepository extends JpaRepository<SavedSearch, Long> {

}
