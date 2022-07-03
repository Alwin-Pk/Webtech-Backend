package de.htw.backend;

import de.htw.backend.service.AppointmentService;
import de.htw.backend.web.AppointmentRestController;
import de.htw.backend.web.api.Appointment;
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

@WebMvcTest (controllers = AppointmentRestController.class)
public class AppointmentIntegrationsTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentServiceTest;

    @Test
    public void testAppointmentRoute() throws Exception
    {
        // Test data and service mock
        Appointment a3 = new Appointment(50L, "17:21", "26.06.2022", 23L);

        when(appointmentServiceTest.findById(50L)).thenReturn(a3);

        //Expected String
        String expected = "{\"aid\":50,\"time\":\"17:21\",\"date\":\"26.06.2022\",\"guest_id\":23}";

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/appointments/50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
