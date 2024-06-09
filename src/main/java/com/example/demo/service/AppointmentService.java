package com.example.demo.service;

import com.example.demo.repository.AppointmentJpaRepository;
import com.example.demo.repository.DoctorServiceJpaRepository;
import com.example.demo.entity.*;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    private final AppointmentJpaRepository appointmentJpaRepository;
    private final DoctorServiceJpaRepository doctorServiceJpaRepository;

    public AppointmentService(AppointmentJpaRepository appointmentJpaRepository, DoctorServiceJpaRepository doctorServiceJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
        this.doctorServiceJpaRepository = doctorServiceJpaRepository;
    }

    @PostConstruct
    public void init() {
        // Example doctor services
        // Example doctor services
        if(doctorServiceJpaRepository.count() == 0) {
            DoctorService service1 = new DoctorService("Consultation", 80.0);
            DoctorService service2 = new DoctorService("Vaccination", 40.0);
            DoctorService service3 = new DoctorService("Surgery", 120.0);
            DoctorService service4 = new DoctorService("Dental Cleaning", 60.0);
            DoctorService service5 = new DoctorService("Microchipping", 30.0);
            DoctorService service6 = new DoctorService("X-ray", 100.0);
            doctorServiceJpaRepository.saveAll(List.of(service1, service2, service3, service4, service5, service6));

            if(appointmentJpaRepository.count() == 0) {
                appointmentJpaRepository.saveAll(List.of(
                        new Appointment("Buddy", LocalDateTime.now().minusDays(1), "Dr. Smith", List.of(service2), "", Status.CREATED, 50.0, List.of(service2.getId())),
                        new Appointment("Milo", LocalDateTime.now().minusDays(2), "Dr. Brown", List.of(service1), "Vaccinated", Status.COMPLETED, 30.0, List.of(service1.getId())),
                        new Appointment("Bella", LocalDateTime.now().minusDays(3), "Dr. White", List.of(service3), "", Status.COMPLETED, 150.0, List.of(service3.getId())),
                        // new Appointment("Lucy", LocalDateTime.now().minusDays(4), "Dr. Johnson", List.of(service2), "Healthy", Status.CONFIRMED, 80.0, List.of(service2.getId(), service1.getId())),
                        new Appointment("Max", LocalDateTime.now().minusDays(5), "Dr. Black", List.of(service3), "Recovered", Status.COMPLETED, 150.0, List.of(service3.getId())),
                        new Appointment("Charlie", LocalDateTime.now().minusDays(6), "Dr. Green", List.of(service2), "", Status.CREATED, 50.0, List.of(service2.getId()))
                ));
            }
        }





    }

    public Page<AppointmentProjection> getAppointments(Pageable pageable) {
        return appointmentJpaRepository.findAllProjectedBy(pageable);
    }


    public Page<AppointmentProjection> getFilteredAppointments(
            String animalName,
            String doctorName,
            Status status,
            String diagnosis,
            Double totalCost,
            Long id,
            String appointmentDateTime,
            Pageable pageable) {
        return appointmentJpaRepository.findFilteredAppointments(
                animalName,
                doctorName,
                status,
                diagnosis,
                totalCost,
                id,
                appointmentDateTime,
                pageable);
    }

    @Transactional
    public Long saveAppointment(AppointmentDTO appointmentDTO) {
        List<DoctorService> services = doctorServiceJpaRepository.findAllById(appointmentDTO.getServiceIds());
        double totalCost = services.stream().mapToDouble(DoctorService::getPrice).sum();


        Appointment appointment = new Appointment(
                appointmentDTO.getAnimalName(),
                appointmentDTO.getAppointmentDateTime(),
                appointmentDTO.getDoctorName(),
                services,
                appointmentDTO.getDiagnosis(),
                Status.CREATED,
                totalCost,
                appointmentDTO.getServiceIds() // Add serviceIds to the constructor
        );


        appointmentJpaRepository.save(appointment);
        return appointment.getId();
    }

    @Transactional
    public Long updateAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = appointmentJpaRepository.findById(appointmentDTO.getId()).orElseThrow();

        appointment.setAnimalName(appointmentDTO.getAnimalName());
        appointment.setDoctorName(appointmentDTO.getDoctorName());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());

        List<DoctorService> services = doctorServiceJpaRepository.findAllById(appointmentDTO.getServiceIds());
        appointment.setDoctorService(services);
        appointment.setDiagnosis(appointmentDTO.getDiagnosis());
        if (appointmentDTO.getStatus() == Status.COMPLETED && (appointmentDTO.getDiagnosis() == null || appointmentDTO.getDiagnosis().isEmpty())) {
            throw new RuntimeException("Diagnosis must be provided to complete the appointment");
        }
        appointment.setServiceIds(appointmentDTO.getServiceIds());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setTotalCost(appointmentDTO.getTotalCost());

        appointmentJpaRepository.save(appointment);
        return appointment.getId();
    }




}
