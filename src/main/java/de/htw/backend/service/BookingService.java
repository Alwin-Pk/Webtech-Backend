package de.htw.backend.service;

import de.htw.backend.persistence.BookingEntity;
import de.htw.backend.persistence.BookingRepo;
import de.htw.backend.web.api.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService
{
    @Autowired
    private final BookingRepo bookingRepo;

    public BookingService(BookingRepo bookingRepo) { this.bookingRepo = bookingRepo; }

    private Booking transformBooking(BookingEntity bookingEntity)
    {
        return new Booking(
                bookingEntity.getBid(),
                bookingEntity.getGuest_id(),
                bookingEntity.getDate(),
                bookingEntity.getBookedService()
        );
    }

    public List<Booking> findAll()
    {
        List<BookingEntity> booking = bookingRepo.findAll();
        return booking.stream()
                .map(this::transformBooking)
                .collect(Collectors.toList());
    }

    public Booking get(Long id)
    {
        return transformBooking(bookingRepo.findById(id).orElseThrow(
                () -> new NullPointerException("The Guest with ID " + id + " does not exist."))
        );
    }

    public Booking findById(Long id)
    {
        var BookingEntity = bookingRepo.findById(id);
        return BookingEntity.isPresent() ? transformBooking(BookingEntity.get()) : null;
    }
}
