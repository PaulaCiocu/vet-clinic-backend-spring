package com.example.demo.repository;

import com.example.demo.entity.DoctorService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorServiceJpaRepository extends JpaRepository<DoctorService, Long> {
    List<DoctorService> findAll();

}
