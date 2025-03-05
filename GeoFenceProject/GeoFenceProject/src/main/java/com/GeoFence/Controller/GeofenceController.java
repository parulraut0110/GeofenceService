package com.GeoFence.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GeoFence.Service.GeofenceService;

@RestController 
public class GeofenceController {

    @Autowired
    private GeofenceService geofenceService;

    @GetMapping("/check-geofence")
    public String checkGeofence(@RequestParam double latitude, @RequestParam double longitude) {
        boolean isInside = geofenceService.isPointInsideGeofence(latitude, longitude);
        return isInside ? "Inside Geofence" : "Outside Geofence";
    }
}
