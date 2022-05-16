package de.htw.webtechprojekt.web;



import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.web.api.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@RestController
public class GuestRestController
{
    private final GuestRepository guestRepository;

    public GuestRestController(GuestRepository guestRepository) {this.guestRepository = guestRepository;}

    @GetMapping (path = "/api/v1/guests")
    public ResponseEntity<List<GuestEntity>> fetchGuest(){
        var guests = guestRepository.findAll();
        return ResponseEntity.ok(guests);
    }
}


    /*
    private final GuestService guestService;

    public GuestRestController (GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping(path = "/api/v1/guests")
    public ResponseEntity<List<Guest>> fetchGuests(){
        return ResponseEntity.ok(guestService.findAll());
    }

    @GetMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> fetchGuestById(@PathVariable Long id){
        var guest = guestService.findById(id);
        return guest !=null? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }

   */
/* @PostMapping(path = "/api/v1/guests")
    public ResponseEntity<Void> createGuest(@Validated @RequestBody GuestManipulationRequest request) throws URISyntaxException{
        var guest = guestService.create(request);
        URI uri = new URI("/api/v1/guests/" + guest.getId());
        return ResponseEntity.created(uri).build();
    }*//*


   */
/* @PutMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody GuestManipulationRequest request){
        var guest = guestService.update(id, request);
        return guest != null? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id){
        boolean successful = guestService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
*//*


}

*/
