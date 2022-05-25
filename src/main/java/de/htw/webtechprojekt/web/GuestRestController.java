package de.htw.webtechprojekt.web;



import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.service.GuestService;
import de.htw.webtechprojekt.web.api.Guest;
import de.htw.webtechprojekt.web.api.GuestManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private final GuestService guestService;

    public GuestRestController(GuestService guestService)
    {
        this.guestService = guestService;
    }

    @GetMapping(path = "/api/v1/guests")
    public ResponseEntity<List<Guest>> fetchGuests()
    {
        return ResponseEntity.ok(guestService.findAll());
    }

    @GetMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> fetchGuestById(@PathVariable(name = "id") Long id)
    {
        var guest = guestService.findById(id);
        return guest != null ? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/guests")
    public ResponseEntity<Void> createGuest(@RequestBody GuestManipulationRequest request) throws URISyntaxException
    {
       var guest = guestService.create(request);
       URI uri = new URI("/api/v1/guests/" + guest.getId());
       return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Void> deleteGuestById(@PathVariable(name = "id") Long id)
    {
        boolean successful = guestService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> updatePerson(@PathVariable Long id, @RequestBody GuestManipulationRequest request)
    {
        var guest = guestService.update(id, request);
        return guest != null ? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }
}
