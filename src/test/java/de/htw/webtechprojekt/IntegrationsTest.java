package de.htw.webtechprojekt;

import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.service.GuestService;
import de.htw.webtechprojekt.web.api.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IntegrationsTest.class)
public class IntegrationsTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestServiceTest;

    @Test
    public void testGuestRoute() throws Exception
    {
        // Test data and service mock
        var g3 = new Guest(3L, "0123456789",
                           "Musterfrau",
                           "Franciska",
                           "franci.musterfrau@test.de",
                           "25.05.2022 20:07");
        when(guestServiceTest.get(3L)).thenReturn(g3);

        //Expected String
        String expected = "GuestEntity{" +
                "id=" + "3" +
                ", telefonNummer='" + "0123456789" + '\'' +
                ", lastName='" + "Musterfrau" + '\'' +
                ", firstName='" + "Franciska" + '\'' +
                ", emailAdresse='" + "franci.musterfrau@test.de" + '\'' +
                ", date='" + "25.05.2022 20:07" + '\'' +
                '}';

        //Call and assertion
        this.mockMvc.perform(get("/api/guests/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
