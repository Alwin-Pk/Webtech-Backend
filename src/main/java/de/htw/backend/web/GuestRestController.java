package de.htw.backend.web;



import de.htw.backend.service.GuestService;
import de.htw.backend.web.api.Guest;
import de.htw.backend.web.api.GuestManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<Void> createGuest(@Valid @RequestBody GuestManipulationRequest request) throws URISyntaxException
    {
       var valid = validate(request);
       if (valid)
       {
           var guest = guestService.create(request);
           URI uri = new URI("/api/v1/guests/" + guest.getId());
           return ResponseEntity.created(uri).build();
       } else {
           return ResponseEntity.badRequest().build();
       }
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

    private boolean validate(GuestManipulationRequest request)
    {
        return request.getFirstName() != null
                && !request.getFirstName().isBlank()
                && request.getLastName() != null
                && !request.getLastName().isBlank()
                && request.getTelefonNummer() != null
                && !request.getTelefonNummer().isBlank()
                && request.getEmailAdresse() != null
                && !request.getEmailAdresse().isBlank()
                && request.getDate() != null
                && !request.getDate().isBlank();
    }
}
