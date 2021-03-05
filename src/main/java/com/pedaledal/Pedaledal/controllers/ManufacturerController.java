package com.pedaledal.Pedaledal.controllers;

import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import com.pedaledal.Pedaledal.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping(value = "/manufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturersWithFilter(
            @RequestParam(name = "manufacturerName", required = false) String manufacturerName){
        if (manufacturerName != null){
            return new ResponseEntity<>(manufacturerRepository.findManufacturerByName(manufacturerName), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(manufacturerRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/animals/users")
//    public ResponseEntity<List<User>> findAnimalsForUsersNamedQuery(
//            @RequestParam(name = "username") String username){
//        return new ResponseEntity(animalRepository.findAnimalByUserUserName(username), HttpStatus.OK);
//    }

    @GetMapping(value = "/manufacturers/{id}")
    public ResponseEntity getManufacturer(@PathVariable Long id){
        return new ResponseEntity(manufacturerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/manufacturers")
    public ResponseEntity<Manufacturer> postManufacturer(@RequestBody Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/manufacturers/{id}")
    public ResponseEntity<Manufacturer> deleteManufacturer(@PathVariable Long id){
        Manufacturer found = manufacturerRepository.getOne(id);
        manufacturerRepository.delete(found);
        return new ResponseEntity(manufacturerRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/manufacturers/{id}")
    public ResponseEntity<Manufacturer> putManufacturer(@RequestBody Manufacturer manufacturer, @PathVariable Long id){
        Manufacturer manufacturerToUpdate = manufacturerRepository.findById(id).get();
        manufacturer.setName(manufacturer.getName());
        manufacturer.setDescription(manufacturer.getDescription());
        manufacturer.setWebsite(manufacturer.getWebsite());
        manufacturerRepository.save(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }
}
