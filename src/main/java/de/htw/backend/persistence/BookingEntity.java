package de.htw.backend.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity (name = "bookings")
public class BookingEntity
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "bid")
    private Long bid;

    @Column (name = "guest_id")
    private Long guest_id;

    @Column (name = "time")
    private LocalDateTime date;

    @Column (name = "bookedService")
    private String bookedService;

    public BookingEntity(Long guest_id, LocalDateTime date, String bookedService)
    {
        this.guest_id = guest_id;
        this.date = date;
        this.bookedService = bookedService;
    }

    protected BookingEntity() {}

    public Long getBid()
    {
        return bid;
    }

    public void setBid(Long aid)
    {
        if (this.bid == null) this.bid = aid;
        else throw new IllegalCallerException("Cannot set booking id, because booking already has id (" + this.bid + ") assigned.");
    }

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
