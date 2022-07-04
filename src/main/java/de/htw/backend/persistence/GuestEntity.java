package de.htw.backend.persistence;

import javax.persistence.*;

@Entity (name = "guests")
public class GuestEntity
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "telefonNummer")
    private String telefonNummer;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "firstName")
    private String firstName;

    @Column (name = "emailAdresse")
    private String emailAdresse;

    @Column (name = "date")
    private String date;

    public GuestEntity(String telefonNummer, String lastName, String firstName, String emailAdresse, String date)
    {
        this.telefonNummer = telefonNummer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAdresse = emailAdresse;
        this.date = date;
    }

    protected GuestEntity() {}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
//        if (this.id == null)
            this.id = id;
//        else throw new IllegalCallerException("Cannot set guest id, because guest already has id (" + this.id + ") assigned.");
    }

    public String getTelefonNummer()
    {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer)
    {
        this.telefonNummer = telefonNummer;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getEmailAdresse()
    {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse)
    {
        this.emailAdresse = emailAdresse;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
