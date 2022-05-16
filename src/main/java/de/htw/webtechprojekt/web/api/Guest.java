
package de.htw.webtechprojekt.web.api;

import java.time.LocalDateTime;

public class Guest {

    private Long id;
    private String telefonNummer;
    private String lastName;
    private String firstName;
    private String emailAdresse;
    private LocalDateTime date;

    public Guest(Long id, String telefonNummer, String lastName, String firstName, String emailAdresse, LocalDateTime date) {
        this.id = id;
        this.telefonNummer = telefonNummer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAdresse = emailAdresse;
        this.date = date;
    }

    protected Guest() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
