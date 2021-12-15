package com.example.assignment3intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MapIntent : AppCompatActivity() {
    lateinit var btn_map: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_intent)

        btn_map = findViewById(R.id.btn_map)
        var user_input_location: EditText = findViewById(R.id.map)

        btn_map.setOnClickListener({
            var loc = user_input_location.text
// Create a Uri from an intent string. Use the result to create an Intent.
            val gmmIntentUri = Uri.parse(loc.toString())

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
// Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps")

// Attempt to start an activity that can handle the Intent
            startActivity(mapIntent)
        })
    }
}