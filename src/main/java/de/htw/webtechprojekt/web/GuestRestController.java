package de.htw.webtechprojekt.web;



import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.service.GuestService;
import de.htw.webtechprojekt.web.api.Guest;
import de.htw.webtechprojekt.web.api.GuestManipulationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@RestController
public class GuestRestController
{
    private final GuestService guestService;

    public GuestRestController(GuestService guestService)
    {
        this.guestService = guestService;
    }

    @GetMapping (path = "/api/v1/guests")
    public ResponseEntity<List<Guest>> fetchGuests()
    {
        return ResponseEntity.ok(guestService.findAll());
    }

    @PostMapping(path = "/api/v1/guests")
    public ResponseEntity<Void> createGuest(@RequestBody GuestManipulationRequest request) throws URISyntaxException
    {
       var guest = guestService.create(request);
       URI uri = new URI("/api/v1/guests/" + guest.getId());
       return ResponseEntity.created(uri).build();
    }
}
