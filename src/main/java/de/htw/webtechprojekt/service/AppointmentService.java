package de.htw.webtechprojekt.service;

import de.htw.webtechprojekt.persistence.AppointmentEntity;
import de.htw.webtechprojekt.persistence.AppointmentRepo;
import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.web.api.Appointment;
import de.htw.webtechprojekt.web.api.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService
{
    @Autowired
    private final AppointmentRepo appointmentRepo;

    public AppointmentService(AppointmentRepo appointmentRepo) { this.appointmentRepo = appointmentRepo; }

    private Appointment transformAppointment(AppointmentEntity appointmentEntity)
    {
        return new Appointment(
                appointmentEntity.getAid(),
                appointmentEntity.getTime(),
                appointmentEntity.getDate(),
                appointmentEntity.getGuest_id()
        );
    }

    public List<Appointment> findAll()
    {
        List<AppointmentEntity> appointment = appointmentRepo.findAll();
        return appointment.stream()
                .map(this::transformAppointment)
                .collect(Collectors.toList());
    }
}
