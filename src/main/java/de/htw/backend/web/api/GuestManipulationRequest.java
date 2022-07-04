package de.htw.backend.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class GuestManipulationRequest
{

    private String telefonNummer;

    private String lastName;

//    @Size(min = 3, max = 100, message = "Der Name muss mindestens aus 3 Buchstaben bestehen.")
    private String firstName;

    private String emailAdresse;

//    @NotBlank(message = "Das Feld darf nicht leer sein.")
    private String date;

/*    @Pattern(
            regexp = "MALE|FEMALE|DIVERSE",
            message = "Please provide 'MALE', 'FEMALE' or 'DIVERSE' for gender."
    )*/

    public GuestManipulationRequest(String telefonNummer, String lastName, String firstName, String emailAdresse, String date)
    {
        this.telefonNummer = telefonNummer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAdresse = emailAdresse;
        this.date = date;
    }

    public GuestManipulationRequest() {}

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