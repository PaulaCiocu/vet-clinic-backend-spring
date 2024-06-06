package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDTO {
    private Long id;
    private String animalName;
    private LocalDateTime appointmentDateTime;
    private String doctorName;
    private List<Long> serviceIds; // List of selected service IDs
    private Status status;
    private Double totalCost;
    private String diagnosis;
    public AppointmentDTO() {}

    public AppointmentDTO(Long id, String animalName, LocalDateTime appointmentDateTime, String doctorName, List<Long> serviceIds, Status status, Double totalCost, String diagnosis) {
        this.id = id;
        this.animalName = animalName;
        this.appointmentDateTime = appointmentDateTime;
        this.doctorName = doctorName;
        this.serviceIds = serviceIds;
        this.status = status;
        this.totalCost = totalCost;
        this.diagnosis = diagnosis;
    }

    public List<Long> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Long> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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
}
