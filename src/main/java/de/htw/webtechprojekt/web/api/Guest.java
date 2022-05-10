package de.htw.webtechprojekt.web.api;

public class Guest {

    private long id;
    private String telefonNummer;
    private String lastName;
    private String firstName;
    private String emailAdresse;
    private String date;
    private String time;

    public Guest(long id, String telefonNummer, String lastName, String firstName, String emailAdresse, String date, String time) {
        this.id = id;
        this.telefonNummer = telefonNummer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAdresse = emailAdresse;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
