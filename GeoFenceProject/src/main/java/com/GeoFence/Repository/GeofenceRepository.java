package com.GeoFence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GeoFence.Entity.Geofence;

@Repository
public interface GeofenceRepository extends JpaRepository<Geofence, Long> {

    @Query(value = "SELECT * FROM geofence WHERE ST_Contains(boundary, ST_GeomFromText(:point, 4326))", nativeQuery = true)
    Optional<Geofence> findGeofenceContainingPoint(@Param("point") String point);
}
