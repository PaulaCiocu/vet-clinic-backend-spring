package com.example.demo.service;

import com.example.demo.repository.DoctorServiceJpaRepository;
import com.example.demo.entity.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceService {
    private DoctorServiceJpaRepository doctorServiceJpaRepository;
    public DoctorServiceService(DoctorServiceJpaRepository doctorServiceJpaRepository) {
        this.doctorServiceJpaRepository = doctorServiceJpaRepository;
    }


    public List<DoctorService> findAll() {
        return doctorServiceJpaRepository.findAll();
    }

    public List<DoctorService> findAllById(List<Long> ids) {
        return doctorServiceJpaRepository.findAllById(ids);
    }

    public DoctorService save(DoctorService doctorService) {
        return doctorServiceJpaRepository.save(doctorService);
    }
}
