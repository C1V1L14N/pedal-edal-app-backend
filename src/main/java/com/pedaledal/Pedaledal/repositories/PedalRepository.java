package com.pedaledal.Pedaledal.repositories;

import com.pedaledal.Pedaledal.models.pedals.EffectType;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedalRepository extends JpaRepository<Pedal, Long> {

    List<Pedal> findPedalByNameIgnoreCase(String pedalName);
    List<Pedal> findAllPedalsByRating(Integer rating);
    List<Pedal> findAllPedalsByEffectType(EffectType type);
    List<Pedal> findAllPedalsByManufacturersName(String manufacturerName);


    // pedals by price
    // pedals by dimensions
    // top 10 pedals by rating
    // top 10 pedals by rating by manufacturer
    // Top 10 pedals by rating by type
    // Top 10 pedals by rating where stereo true
    // Top 10 pedals by rating where stereo false
}
