package de.htw.backend.web.api;

import java.time.LocalDateTime;

public class BookingEditRequest
{
    private Long guest_id;
    private LocalDateTime date;
    private String bookedService;

    public BookingEditRequest(Long guest_id, LocalDateTime date, String bookedService)
    {
        this.guest_id = guest_id;
        this.date = date;
        this.bookedService = bookedService;
    }

    public BookingEditRequest() {}

    public Long getGuest_id()
    {
        return guest_id;
    }

    public void setGuest_id(Long guest_id)
    {
        this.guest_id = guest_id;
    }

    public LocalDateTime getDate()
    {
        return date;
    }

    public void setDate(LocalDateTime date)
    {
        this.date = date;
    }

    public String getBookedService()
    {
        return bookedService;
    }

    public void setBookedService(String bookedService)
    {
        this.bookedService = bookedService;
    }
}
