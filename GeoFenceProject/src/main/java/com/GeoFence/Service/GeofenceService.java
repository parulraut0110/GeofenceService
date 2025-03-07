package com.GeoFence.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GeoFence.Repository.GeofenceRepository;

@Service
public class GeofenceService {

    @Autowired
    private GeofenceRepository geofenceRepository;

    public boolean isInsideGeofence(double lat, double lon) {
        String point = "POINT(" + lon + " " + lat + ")";
        return geofenceRepository.findGeofenceContainingPoint(point).isPresent();
    }
}
