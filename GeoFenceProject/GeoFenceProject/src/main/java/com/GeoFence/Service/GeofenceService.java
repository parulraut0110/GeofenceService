package com.GeoFence.Service;

import org.springframework.stereotype.Service;

@Service
public class GeofenceService {

    // Define the center of the geofence (latitude, longitude) and the radius in meters
    private static final double GEOFENCE_LATITUDE = 21.1732734; // Example: San Francisco
    private static final double GEOFENCE_LONGITUDE = 79.0962517;
    private static final double GEOFENCE_RADIUS = 10; // 1 km radius

    public boolean isPointInsideGeofence(double latitude, double longitude) {
        double distance = calculateDistance(GEOFENCE_LATITUDE, GEOFENCE_LONGITUDE, latitude, longitude);
        return distance <= GEOFENCE_RADIUS;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula to calculate the distance between two points on the Earth
        final int R = 6371; // Radius of the Earth in kilometers
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // Convert to meters
        return distance;
    }
}