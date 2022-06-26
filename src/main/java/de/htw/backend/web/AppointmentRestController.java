package de.htw.backend.web;

import de.htw.backend.service.AppointmentService;
import de.htw.backend.web.api.Appointment;
import de.htw.backend.web.api.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentRestController
{
    @Autowired
    private final AppointmentService appointmentService;

    public AppointmentRestController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }

    @GetMapping (path = "/api/v1/appointments")
    public ResponseEntity<List<Appointment>> fetchAppointments()
    {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping(path = "/api/v1/appointments/{id}")
    public ResponseEntity<Appointment> fetchAppointmentById(@PathVariable (name = "id") Long id)
    {
        var appointment = appointmentService.findById(id);
        return appointment != null ? ResponseEntity.ok(appointment) : ResponseEntity.notFound().build();
    }
}
