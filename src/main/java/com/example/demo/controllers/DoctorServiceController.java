package com.example.demo.controllers;

import com.example.demo.entity.DoctorService;
import com.example.demo.service.DoctorServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("services")
public class DoctorServiceController {
    private final DoctorServiceService doctorServiceService;

    public DoctorServiceController(DoctorServiceService doctorServiceService) {
        this.doctorServiceService = doctorServiceService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<DoctorService> getAllDoctorServices() {
        return doctorServiceService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<DoctorService> createService(@RequestBody DoctorService doctorService) {
        return ResponseEntity.ok(doctorServiceService.save(doctorService));
    }
}
