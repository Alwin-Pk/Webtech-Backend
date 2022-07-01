package de.htw.backend;

import de.htw.backend.service.BookingService;
import de.htw.backend.web.BookingRestController;
import de.htw.backend.web.api.Booking;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (controllers = BookingRestController.class)
public class BookingIntegrationsTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingServiceTest;

    @Test
    public void testBookingRoute() throws Exception
    {
        // Test data and service mock
        String str = "2016-03-04 11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var dateTime = LocalDateTime.parse(str, formatter);

        Booking b = new Booking(50L, 23L, dateTime, "Gesichtsbehandlung");

        when(bookingServiceTest.findById(50L)).thenReturn(b);

        //Expected String
        String expected = "\"bid\":50,\"guest_id\":23,\"date\":[2016,3,4,11,30],\"bookedService\":\"Gesichtsbehandlung\"";

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/bookings/50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
