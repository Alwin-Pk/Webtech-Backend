package de.htw.backend;

import de.htw.backend.service.GuestService;
import de.htw.backend.web.GuestRestController;
import de.htw.backend.web.api.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GuestRestController.class)
public class GuestIntegrationsTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    @Test
    public void testGuestRoute() throws Exception
    {
        // Test data and service mock
        Guest guest = new Guest(23L, "0123456789",
                           "Musterfrau",
                           "Franciska",
                           "franci.musterfrau@test.de",
                           "25.05.2022 20:07");

        doReturn(guest).when(guestService).findById(23L);

        //Expected String
        String expected = "\"id\":23,\"telefonNummer\":\"0123456789\"," +
                          "\"lastName\":\"Musterfrau\",\"firstName\":\"Franciska\"," +
                          "\"emailAdresse\":\"franci.musterfrau@test.de\"," +
                          "\"date\":\"25.05.2022 20:07\"";

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/guests/23"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
