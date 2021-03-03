package com.pedaledal.Pedaledal.repositories;

import com.pedaledal.Pedaledal.models.pedals.Pedal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedalRepository extends JpaRepository<Pedal, Long> {

    List<Pedal> findPedalByName(String name);
}
