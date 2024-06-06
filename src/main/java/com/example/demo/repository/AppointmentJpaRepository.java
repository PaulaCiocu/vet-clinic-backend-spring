package com.example.demo.repository;

import com.example.demo.entity.Appointment;

import com.example.demo.entity.AppointmentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AppointmentJpaRepository extends JpaRepository<Appointment, Long> {
    Page<AppointmentProjection> findAllProjectedBy(Pageable pageable);
    // Define a query to filter appointments based on optional parameters
    @Query("SELECT a FROM Appointment a " +
            "WHERE (:filter IS NULL OR " +
            "LOWER(a.animalName) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(a.doctorName) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(a.status) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(a.diagnosis) LIKE LOWER(CONCAT('%', :filter, '%')))")
    Page<AppointmentProjection> findFilteredAppointments(
            @Param("filter") String filter,
            Pageable pageable
    );

}
