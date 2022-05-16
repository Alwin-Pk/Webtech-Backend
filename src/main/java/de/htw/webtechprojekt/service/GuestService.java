package de.htw.webtechprojekt.service;

import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.web.api.Guest;
import de.htw.webtechprojekt.web.api.GuestManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService  {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository)
    {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll()
    {
        List<GuestEntity> guests = guestRepository.findAll();
        return guests.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Guest create(GuestManipulationRequest request)
    {
        var guestEntity = new GuestEntity(request.getTelefonNummer(), request.getLastName(), request.getFirstName(), request.getEmailAdresse(), request.getDate());
        guestEntity = guestRepository.save(guestEntity);
        return transformEntity(guestEntity);
    }

    private Guest transformEntity(GuestEntity guestEntity)
    {
        return new Guest(
                guestEntity.getId(),
                guestEntity.getTelefonNummer(),
                guestEntity.getLastName(),
                guestEntity.getFirstName(),
                guestEntity.getEmailAdresse(),
                guestEntity.getDate()
        );
    }
}
