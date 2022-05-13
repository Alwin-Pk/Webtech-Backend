package de.htw.webtechprojekt.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name= "guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="telefonnummer", nullable = false)
    private String telefonNummer;

    @Column(name="last name", nullable = false)
    private String lastName;

    @Column(name="first name", nullable = false)
    private String firstName;

    @Column(name="email Adresse", nullable = false)
    private String emailAdresse;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    public GuestEntity (String telefonNummer, String lastName, String firstName, String emailAdresse, LocalDateTime date)
    {
        this.telefonNummer = telefonNummer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAdresse = emailAdresse;
        this.date = date;
    }

    protected GuestEntity() {};

    public Long getId() {
        return id;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
