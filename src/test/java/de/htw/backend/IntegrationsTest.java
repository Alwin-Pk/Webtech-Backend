package de.htw.backend;

import de.htw.backend.persistence.AppointmentRepo;
import de.htw.backend.persistence.GuestRepository;
import de.htw.backend.service.AppointmentService;
import de.htw.backend.service.GuestService;
import de.htw.backend.web.GuestRestController;
import de.htw.backend.web.api.Appointment;
import de.htw.backend.web.api.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages = "de.htw")
@WebMvcTest(GuestRestController.class)
public class IntegrationsTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestServiceTest;

    @MockBean
    private AppointmentService appointmentServiceTest;

    @Test
    public void testGuestRoute() throws Exception
    {
        // Test data and service mock
        Guest g3 = new Guest(23L, "0123456789",
                           "Musterfrau",
                           "Franciska",
                           "franci.musterfrau@test.de",
                           "25.05.2022 20:07");

        when(guestServiceTest.get(23L)).thenReturn(g3);

        //Expected String
        String expected = "Guest{" +
                "id=" + "23" +
                ", telefonNummer='" + "0123456789" + '\'' +
                ", lastName='" + "Musterfrau" + '\'' +
                ", firstName='" + "Franciska" + '\'' +
                ", emailAdresse='" + "franci.musterfrau@test.de" + '\'' +
                ", date='" + "25.05.2022 20:07" + '\'' +
                '}';

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/guests/23"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testAppointmentRoute() throws Exception
    {
        // Test data and service mock
        Appointment a3 = new Appointment(50L, "17:21", "26.06.2022", 23L);

        when(appointmentServiceTest.get(50L)).thenReturn(a3);

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/appointments/50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
