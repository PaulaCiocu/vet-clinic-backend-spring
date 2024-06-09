package com.example.demo.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalName;
    private LocalDateTime appointmentDateTime;
    private String doctorName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "appointment_services",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_service_id"))
    private List<DoctorService> doctorService;


    private String diagnosis;

    @ElementCollection
    private List<Long> serviceIds; // List of selected service IDs

    @Enumerated(EnumType.STRING)
    private Status status;
    private Double totalCost;

    public Appointment() {
    }

    public Appointment(String animalName, LocalDateTime appointmentDateTime, String doctorName, List<DoctorService> doctorService, String diagnosis, Status status, Double totalCost, List<Long> serviceIds) {
        this.animalName = animalName;
        this.appointmentDateTime = appointmentDateTime;
        this.doctorName = doctorName;
        this.doctorService = doctorService;
        this.diagnosis = diagnosis;
        this.status = status;
        this.totalCost = totalCost;
        this.serviceIds = serviceIds;
    }

    public List<Long> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Long> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }



    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public List<DoctorService> getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(List<DoctorService> doctorService) {
        this.doctorService = doctorService;
    }
}
