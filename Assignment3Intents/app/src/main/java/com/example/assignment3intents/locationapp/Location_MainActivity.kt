package com.example.assignment3intents.locationapp

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.assignment3intents.R
import java.util.jar.Manifest

class Location_MainActivity : AppCompatActivity() {
    lateinit var loc:Location
    lateinit var locationManager: LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_main)
        locationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),121)
        }
        var locationListenere=object:LocationListener{
            override fun onLocationChanged(p0: Location) {
                getLocation(p0)
            }

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,100f,locationListenere)
    }

    private fun getLocation(p0: Location) {
    Log.d("location-app",p0.latitude.toString())
    }
}