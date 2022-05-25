package de.htw.webtechprojekt.service;

import de.htw.webtechprojekt.persistence.GuestEntity;
import de.htw.webtechprojekt.persistence.GuestRepository;
import de.htw.webtechprojekt.web.api.Guest;
import de.htw.webtechprojekt.web.api.GuestManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService
{
    @Autowired
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

    public Guest findById(Long id)
    {
        var guestEntity = guestRepository.findById(id);
        return guestEntity.isPresent() ? transformEntity(guestEntity.get()) : null;
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

    public Guest update(Long id, GuestManipulationRequest request)
    {
        var guestEntityOptional = guestRepository.findById(id);
        if (guestEntityOptional.isEmpty()) return null;

        var guestEntity = guestEntityOptional.get();
        guestEntity.setTelefonNummer(request.getTelefonNummer());
        guestEntity.setLastName(request.getLastName());
        guestEntity.setFirstName(request.getFirstName());
        guestEntity.setEmailAdresse(request.getEmailAdresse());
        guestEntity.setDate(request.getDate());
        guestEntity = guestRepository.save(guestEntity);

        return transformEntity(guestEntity);
    }

    public boolean deleteById(Long id)
    {
        if (!guestRepository.existsById(id)) return false;
        else guestRepository.deleteById(id);
        return true;
    }

    public Guest get(Long id)
    {
        return transformEntity(guestRepository.findById(id).orElseThrow(
                () -> new NullPointerException("The Guest with ID " + id + " does not exist."))
        );
    }
}
