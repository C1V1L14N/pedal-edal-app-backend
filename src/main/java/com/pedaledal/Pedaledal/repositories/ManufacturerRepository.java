package com.pedaledal.Pedaledal.repositories;

import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findManufacturerByName(String manufacturerName);

}
