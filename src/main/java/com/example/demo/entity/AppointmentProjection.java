package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentProjection {
    Long getId();
    String getAnimalName();
    String getDoctorName();
    LocalDateTime getAppointmentDateTime();
    String getStatus();
    String getDiagnosis();
    Double getTotalCost();
    List<Long> getServiceIds();

}
