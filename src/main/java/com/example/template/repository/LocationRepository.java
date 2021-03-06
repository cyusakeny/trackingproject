package com.example.template.repository;

import com.example.template.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByLatitudeAndAndLongitudeAndLocationName(double latitude,double longitude, String name);
}
