package com.example.demo.repository;

import com.example.demo.entity.Appointment;

import com.example.demo.entity.AppointmentProjection;
import com.example.demo.entity.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface AppointmentJpaRepository extends JpaRepository<Appointment, Long>{
    Page<AppointmentProjection> findAllProjectedBy(Pageable pageable);
    @Query("SELECT a.appointmentDateTime as appointmentDateTime, " +
            "a.doctorName as doctorName, " +
            "a.animalName as animalName, " +
            "a.diagnosis as diagnosis, " +
            "a.status as status, " +
            "a.totalCost as totalCost, " +
            "a.id as id "+
            "FROM Appointment a " +
            "WHERE (:doctorName IS NULL OR a.doctorName = :doctorName) " +
            "AND (:animalName IS NULL OR a.animalName = :animalName) " +
            "AND (:status IS NULL OR a.status = :status) " +
            "AND (:diagnosis IS NULL OR a.diagnosis = :diagnosis) " +
            "AND (:totalCost IS NULL OR a.totalCost = :totalCost) " +
            "AND (:id IS NULL OR a.id = :id) " +
            "AND (:appointmentDateTime IS NULL OR a.appointmentDateTime = :appointmentDateTime)")
    Page<AppointmentProjection> findFilteredAppointments(
            @Param("animalName") String animalName,
            @Param("doctorName") String doctorName,
            @Param("status") Status status,
            @Param("diagnosis") String diagnosis,
            @Param("totalCost") Double totalCost,
            @Param("id") Long id,
            @Param("appointmentDateTime") String appointmentDateTime,
            Pageable pageable);
}
