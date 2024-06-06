package com.example.demo.controllers;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.AppointmentDTO;
import com.example.demo.entity.AppointmentProjection;
import com.example.demo.entity.Status;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public Page<AppointmentProjection> getAllAppointments(@PageableDefault(size = 5, sort = "appointmentDateTime", direction = Sort.Direction.DESC) Pageable pageable) {
        return appointmentService.getAppointments(pageable);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter")
    public Page<AppointmentProjection> getFilteredAppointments(
            @RequestParam(required = false) String filter,
            @PageableDefault(size = 5, sort = "appointmentDateTime", direction = Sort.Direction.DESC) Pageable pageable) {
        return appointmentService.getFilteredAppointments(filter, pageable);
    }
//    @GetMapping("/filter")
//    public Page<AppointmentProjection> getFilteredAppointments(
//            @RequestParam(required = false) String animalName,
//            @RequestParam(required = false) String doctorName,
//            @RequestParam(required = false) String status,
//            @RequestParam(required = false) String diagnosis,
//            @RequestParam(required = false) Double totalCost,
//            @RequestParam(required = false) String appointmentDateTime,
//            @PageableDefault(size = 5, sort = "appointmentDateTime", direction = Sort.Direction.DESC) Pageable pageable) {
//
//        Status appointmentStatus = null;
//        if (status != null && !status.isEmpty()) {
//            appointmentStatus = Status.valueOf(status.toUpperCase());
//        }
//        return appointmentService.getFilteredAppointments(animalName, doctorName, appointmentStatus, diagnosis, totalCost, appointmentDateTime, pageable);
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Long> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointmentDTO));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public ResponseEntity<Long> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentDTO));
    }


}
