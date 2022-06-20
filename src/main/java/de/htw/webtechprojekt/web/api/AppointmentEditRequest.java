package de.htw.webtechprojekt.web.api;

public class AppointmentEditRequest
{
    private String time;
    private String date;
    private Long guest_id;

    public AppointmentEditRequest(String time, String date, Long guest_id)
    {
        this.time = time;
        this.date = date;
        this.guest_id = guest_id;
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
