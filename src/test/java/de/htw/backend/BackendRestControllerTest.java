package de.htw.backend;

import de.htw.backend.service.GuestService;
import de.htw.backend.web.GuestRestController;
import de.htw.backend.web.api.Guest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GuestRestController.class)
public class BackendRestControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    @Test
    @DisplayName("Should reach the repo and retrieve guest")
    public void testGetRequest() throws Exception
    {
        var guests = List.of(
                new Guest(23L, "0123456789",
                          "Musterfrau",
                          "Franciska",
                          "franci.musterfrau@test.de",
                          "25.05.2022 20:07"),
                new Guest(53L, "9876543210",
                          "Franciska",
                          "Musterfrau",
                          "musterfrau.franci@de.test",
                          "2022.05.25 07:20"));

        doReturn(guests).when(guestService).findAll();

        Guest guest = new Guest(23L, "0123456789",
                                "Musterfrau",
                                "Franciska",
                                "franci.musterfrau@test.de",
                                "25.05.2022 20:07");

        //Call and assertion
        this.mockMvc.perform(get("/api/v1/guests"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("Franciska"))
                .andExpect(jsonPath("$[0].lastName").value("Musterfrau"))
                .andExpect(jsonPath("$[0].telefonNummer").value("0123456789"))
                .andExpect(jsonPath("$[0].emailAdresse").value("franci.musterfrau@test.de"))
                .andExpect(jsonPath("$[0].date").value("25.05.2022 20:07"))
                .andExpect(jsonPath("$[1].firstName").value("Musterfrau"))
                .andExpect(jsonPath("$[1].lastName").value("Franciska"))
                .andExpect(jsonPath("$[1].telefonNummer").value("9876543210"))
                .andExpect(jsonPath("$[1].emailAdresse").value("musterfrau.franci@de.test"))
                .andExpect(jsonPath("$[1].date").value("2022.05.25 07:20"));
    }

    @Test
    @DisplayName("Should throw 404 error if guest is not found")
    public void test404Error() throws Exception
    {
        doReturn(null).when(guestService).findById(anyLong());

        this.mockMvc.perform(get("/api/v1/guests/420"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should create a guest from a json String")
    public void testGuestCreation() throws Exception
    {
        String jsonToGuest = "{\"id\":23,\"telefonNummer\":\"0123456789\"," +
                "\"lastName\":\"Musterfrau\",\"firstName\":\"Franciska\"," +
                "\"emailAdresse\":\"franci.musterfrau@test.de\"," +
                "\"date\":\"25.05.2022 20:07\"}";

        var guest = new Guest(201L, null, null, null, null, null);

        doReturn(guest).when(guestService).create(any());

        this.mockMvc.perform(
                post("/api/v1/guests/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToGuest))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
//                .andExpect(header().string("Location", Matchers.containsString(Long.toString((guest.getId()))))); --alternative
                .andExpect(header().string("Location", Matchers.equalTo("/api/v1/guests/" + guest.getId())));
    }

    @Test
    @DisplayName("Should create a guest from a json String")
    public void testValidation() throws Exception
    {
        String jsonToGuest = "{\"id\":23,\"telefonNummer\":\"0123456789\"," +
                "\"lastName\":\"M\",\"firstName\":\"Franciska\"," +
                "\"emailAdresse\":\"franci.musterfrau@test.de\"," +
                "\"date\":\"\"}";

        this.mockMvc.perform(
                        post("/api/v1/guests/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonToGuest))
                .andExpect(status().isBadRequest());
    }
}
