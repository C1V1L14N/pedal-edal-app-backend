package com.pedaledal.Pedaledal.controllers;

import com.pedaledal.Pedaledal.models.users.User;
import com.pedaledal.Pedaledal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsersWithFilter(
            @RequestParam(name = "useremail", required = false) String useremail){
        if (useremail != null){
            return new ResponseEntity<>(userRepository.findUserByEmail(useremail), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/animals/users")
//    public ResponseEntity<List<User>> findAnimalsForUsersNamedQuery(
//            @RequestParam(name = "username") String username){
//        return new ResponseEntity(animalRepository.findAnimalByUserUserName(username), HttpStatus.OK);
//    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User found = userRepository.getOne(id);
        userRepository.delete(found);
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/users/{id}")
    public ResponseEntity<User> putAnimal(@RequestBody User user, @PathVariable Long id){
        User userToUpdate = userRepository.findById(id).get();
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAgeRange(user.getAgeRange());
        user.setLocation(user.getLocation());
        user.setInstrument(user.getInstrument());
        user.setFaveEffect(user.getFaveEffect());
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
