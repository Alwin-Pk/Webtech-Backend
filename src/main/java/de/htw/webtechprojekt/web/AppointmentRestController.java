package de.htw.webtechprojekt.web;

import de.htw.webtechprojekt.service.AppointmentService;
import de.htw.webtechprojekt.web.api.Appointment;
import de.htw.webtechprojekt.web.api.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AppointmentRestController
{
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
}
