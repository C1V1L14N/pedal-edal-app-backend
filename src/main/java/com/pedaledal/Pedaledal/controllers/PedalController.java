package com.pedaledal.Pedaledal.controllers;

import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import com.pedaledal.Pedaledal.models.pedals.EffectType;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import com.pedaledal.Pedaledal.repositories.ManufacturerRepository;
import com.pedaledal.Pedaledal.repositories.PedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedalController {
    @Autowired
    PedalRepository pedalRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping(value = "/pedals")
    public ResponseEntity<List<Pedal>> getAllPedalsWithFilter(
            @RequestParam(name = "pedalName", required = false) String pedalName,
            @RequestParam(name = "manufacturerName", required = false) String manufacturerName,
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "type", required = false) EffectType type){
        if (pedalName != null){
            return new ResponseEntity<>(pedalRepository.findPedalByNameIgnoreCase(pedalName), HttpStatus.OK);
        }
        if (manufacturerName != null){
            return new ResponseEntity<>(pedalRepository.findAllPedalsByManufacturersName(manufacturerName), HttpStatus.OK);
        }
        if (rating != null){
            return new ResponseEntity<>(pedalRepository.findAllPedalsByRating(rating), HttpStatus.OK);
        }
        if (type != null){
            return new ResponseEntity<>(pedalRepository.findAllPedalsByEffectType(type), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(pedalRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/animals/users")
//    public ResponseEntity<List<User>> findAnimalsForUsersNamedQuery(
//            @RequestParam(name = "username") String username){
//        return new ResponseEntity(animalRepository.findAnimalByUserUserName(username), HttpStatus.OK);
//    }

    @GetMapping(value = "/pedals/{id}")
    public ResponseEntity getPedal(@PathVariable Long id){
        return new ResponseEntity(pedalRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pedals")
    public ResponseEntity<Pedal> postPedal(@RequestBody Pedal pedal){
        pedalRepository.save(pedal);
        return new ResponseEntity<>(pedal, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/pedals/{id}")
    public ResponseEntity<Pedal> deletePedal(@PathVariable Long id){
        Pedal found = pedalRepository.getOne(id);
        pedalRepository.delete(found);
        return new ResponseEntity(pedalRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/pedals/{id}")
    public ResponseEntity<Pedal> putAnimal(@RequestBody Pedal pedal, @PathVariable Long id){
        Pedal pedalToUpdate = pedalRepository.findById(id).get();
        pedalToUpdate.setName(pedal.getName());
        pedalToUpdate.setDescription(pedal.getDescription());
        pedalToUpdate.setComment(pedal.getComment());
        pedalToUpdate.setOwned(pedal.getOwned());
        pedalToUpdate.setEffectType(pedal.getEffectType());
        pedalToUpdate.setRating(pedal.getRating());
        pedalToUpdate.setImage(pedal.getImage());
        pedalToUpdate.setRetailPrice(pedal.getRetailPrice());
        pedalToUpdate.setUsedPrice(pedal.getUsedPrice());
        pedalToUpdate.setLength(pedal.getLength());
        pedalToUpdate.setWidth(pedal.getWidth());
        pedalToUpdate.setHeight(pedal.getHeight());
        pedalToUpdate.setMidi(pedal.getMidi());
        pedalToUpdate.setStereo(pedal.getStereo());
        pedalToUpdate.setJackPlacement(pedal.getJackPlacement());
        pedalToUpdate.setExpressionInput(pedal.getExpressionInput());
        pedalRepository.save(pedalToUpdate);
        return new ResponseEntity<>(pedalToUpdate, HttpStatus.OK);
    }
}
