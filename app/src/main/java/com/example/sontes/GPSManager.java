package com.example.sontes;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class GPSManager implements LocationListener {

    private LocationManager locationManager;

    public GPSManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public void startListening() {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        } catch (SecurityException e) {
            Log.e("GPSManager", "Permission denied to access GPS.", e);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // Handle the location update here
        Log.d("GPSManager", "Location changed: " + location.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }
}