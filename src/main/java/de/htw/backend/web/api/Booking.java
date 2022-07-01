package de.htw.backend.web.api;

import java.time.LocalDateTime;

public class Booking
{
    private Long bid;
    private Long guest_id;
    private LocalDateTime date;
    private String bookedService;

    public Booking(Long bid, Long guest_id, LocalDateTime date, String bookedService)
    {
        this.bid = bid;
        this.guest_id = guest_id;
        this.date = date;
        this.bookedService = bookedService;
    }

    protected Booking() {}

    public Long getBid()
    {
        return bid;
    }

    public void setBid(Long bid)
    {
        this.bid = bid;
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

    public Long getGuest_id()
    {
        return guest_id;
    }

    public void setGuest_id(Long guest_id)
    {
        this.guest_id = guest_id;
    }
}
