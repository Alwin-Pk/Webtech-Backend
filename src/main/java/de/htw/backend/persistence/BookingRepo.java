package de.htw.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity, Long>
{
        List<BookingEntity> findAllByDate(LocalDateTime date);
}
