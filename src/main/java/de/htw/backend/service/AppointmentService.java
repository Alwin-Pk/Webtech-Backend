package de.htw.backend.service;

import de.htw.backend.persistence.AppointmentEntity;
import de.htw.backend.persistence.AppointmentRepo;
import de.htw.backend.web.api.Appointment;
import de.htw.backend.web.api.Guest;
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

    public Appointment get(Long id)
    {
        return transformAppointment(appointmentRepo.findById(id).orElseThrow(
                () -> new NullPointerException("The Guest with ID " + id + " does not exist."))
        );
    }

    public Appointment findById(Long id)
    {
        var AppointmentEntity = appointmentRepo.findById(id);
        return AppointmentEntity.isPresent() ? transformAppointment(AppointmentEntity.get()) : null;
    }
}
