package com.GeoFence.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GeoFence.Service.GeofenceService;

@RestController
@RequestMapping("/api/geo")
public class GeofenceController {

    @Autowired
    private GeofenceService geofenceService;

    @GetMapping("/check")
    public ResponseEntity<String> checkLocation(
            @RequestParam double lat, 
            @RequestParam double lon) {
        
        boolean inside = geofenceService.isInsideGeofence(lat, lon);
        return inside ? ResponseEntity.ok("Inside Geofence") : ResponseEntity.ok("Outside Geofence");
    }
}
