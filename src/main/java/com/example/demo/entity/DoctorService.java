package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "doctor_service")
public class DoctorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private Double price;

    public DoctorService() {}

    public DoctorService(String serviceType, double v) {
        this.name = serviceType;
        this.price = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
