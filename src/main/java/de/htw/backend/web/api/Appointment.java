package de.htw.backend.web.api;

public class Appointment
{
    private Long aid;
    private String time;
    private String date;
    private Long guest_id;

    public Appointment(Long aid, String time, String date, Long guest_id)
    {
        this.aid = aid;
        this.time = time;
        this.date = date;
        this.guest_id = guest_id;
    }

    protected Appointment() {}

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
