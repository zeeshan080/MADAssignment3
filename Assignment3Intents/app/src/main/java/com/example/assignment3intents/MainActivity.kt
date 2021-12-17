package com.example.assignment3intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn_call: Button
    val CALL_REQUEST_CODE=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()

        btn_call = findViewById(R.id.btn_call)
        var user_input_location: EditText = findViewById(R.id.et_loc)

        btn_call.setOnClickListener({
            var tel = user_input_location.text


            val myInt = Intent(Intent.ACTION_CALL)
            myInt.data=Uri.parse("tel:"+tel);
            startActivity(myInt)
            //Toast.makeText(this, "Searching...", Toast.LENGTH_LONG).show()
        })
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("none", "Permission to Call has denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE),
            CALL_REQUEST_CODE)
    }
}