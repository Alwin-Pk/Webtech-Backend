package de.htw.backend.persistence;

import javax.persistence.*;

@Entity (name = "appointments")
public class AppointmentEntity
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "aid")
    private Long aid;

    @Column (name = "time")
    private String time;

    @Column (name = "date")
    private String date;

    @Column (name = "guest_id")
    private Long guest_id;

    public AppointmentEntity(String time, String date, Long guest_id)
    {
        this.time = time;
        this.date = date;
        this.guest_id = guest_id;
    }

    protected AppointmentEntity() {}

    public Long getAid()
    {
        return aid;
    }

    public void setAid(Long aid)
    {
        this.aid = aid;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
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
