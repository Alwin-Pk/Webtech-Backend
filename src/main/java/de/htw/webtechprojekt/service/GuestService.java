
package de.htw.webtechprojekt.service;

/*

import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.web.api.Guest;
import org.springframework.stereotype.Service;
import de.htw.webtechprojekt.web.api.GuestManipulationRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService (GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll(){
        List<GuestEntity> guests = guestRepository.findAll();
        return guests.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Guest findById (Long id){
        var guestEntity = guestRepository.findById(id);
        return guestEntity.map(this::transformEntity).orElse(null);
    }

   */
/* public Guest create(GuestManipulationRequest request) {
        var guestEntity = new GuestEntity(request.getEmailAdresse(), request.getFirstName(), request.getLastName(), request.getDate(), request.getTime());
        guestEntity = guestRepository.save(guestEntity);
        return transformEntity(guestEntity);
        }
*//*

        public Guest update(Long id, GuestManipulationRequest request){
        var guestEntityOptional = guestRepository.findById(id);
        if (guestEntityOptional.isEmpty()){
            return null;
        }

        var guestEntity = guestEntityOptional.get();
        guestEntity.setEmailAdresse(request.getEmailAdresse());
        guestEntity.setFirstName(request.getFirstName());
        guestEntity.setLastName(request.getLastName());
        guestEntity.setDate(request.getDate());
        guestEntity.setTime(request.getTime());
        guestEntity = guestRepository.save(guestEntity);

        return  transformEntity(guestEntity);
    }

    public boolean deleteById (Long id){
        if (!guestRepository.existsById(id)){
            return false;
        }

        guestRepository.deleteById(id);
        return true;
    }

    private Guest transformEntity(GuestEntity guestEntity){
        return new Guest(
                guestEntity.getId(),
                guestEntity.getTelefonNummer(),
                guestEntity.getLastName(),
                guestEntity.getFirstName(),
                guestEntity.getEmailAdresse(),
                guestEntity.getDate(),
                guestEntity.getTime()
        );
    }
}
*/
