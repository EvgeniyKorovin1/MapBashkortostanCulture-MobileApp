package com.example.googlemapsbashkortostan

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsbashkortostan.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val Ufa =LatLng(54.73586872070936, 55.95586260283889)
        val dramTheather= LatLng(54.77248023815661, 56.023013385683825)
        val nurTheather = LatLng(54.75223664218461, 56.02864692102511)
        val kukolTheather = LatLng(54.78966705558768, 56.03551337584304)
        val operaTheather = LatLng(54.72706553397481, 55.94487617224631)
        val bashTheather = LatLng(54.718946012819124, 55.94064176916256)
        val molodTheather= LatLng(54.73292368218311, 55.950855621260395)
        val dvorecKult= LatLng(54.7981752268048, 56.038681262606396)
        val domAct= LatLng(54.72291932616977, 55.94172130167063)
        mMap.addMarker(MarkerOptions().position(dramTheather).title("Государственный академический русский драматический театр Республики Башкортостан").snippet("Основан в 1875 году"))
        mMap.addMarker(MarkerOptions().position(nurTheather).title("Уфимский государственный татарский театр «Нур»").snippet("Основан в 1912 году"))
        mMap.addMarker(MarkerOptions().position(kukolTheather).title("Башкирский государственный театр кукол").snippet("Основан в 1932 году"))
        mMap.addMarker(MarkerOptions().position(operaTheather).title("Башкирский государственный театр оперы и балета").snippet("Основан в 1909 году"))
        mMap.addMarker(MarkerOptions().position(bashTheather).title("Башкирский государственный академический театр драмы им. Мажита Гафури").snippet("Основан в  году"))
        mMap.addMarker(MarkerOptions().position(molodTheather).title("Национальный Молодежный театр им. Мустая Карима").snippet("Основан в 1989 году"))
        mMap.addMarker(MarkerOptions().position(dvorecKult).title("Городской Дворец культуры").snippet("Основан в 1982 году"))
        mMap.addMarker(MarkerOptions().position(domAct).title("Дом актера"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ufa, 11f))
        mMap.isTrafficEnabled = true
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)

            return
        }
        mMap.isMyLocationEnabled = true
    }
}