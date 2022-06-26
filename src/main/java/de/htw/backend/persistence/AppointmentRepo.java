package de.htw.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Long>
{
        List<AppointmentEntity> findAllByDate(String date);
}
