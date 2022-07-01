package de.htw.backend.web;

import de.htw.backend.service.BookingService;
import de.htw.backend.web.api.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingRestController
{
    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    @GetMapping (path = "/api/v1/bookings")
    public ResponseEntity<List<Booking>> fetchBookings()
    {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @GetMapping(path = "/api/v1/bookings/{bid}")
    public ResponseEntity<Booking> fetchBookingsById(@PathVariable (name = "bid") Long bid)
    {
        var booking = bookingService.findById(bid);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }
}
