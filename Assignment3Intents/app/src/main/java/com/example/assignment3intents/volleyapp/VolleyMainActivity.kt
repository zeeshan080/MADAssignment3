package com.example.assignment3intents.volleyapp

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.assignment3intents.R
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import org.json.JSONArray

import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONException


class VolleyMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley_main)

        val btn1: Button =findViewById(R.id.btn2)
        val imagebtn:Button=findViewById(R.id.btn6)
        val stringbtn:Button=findViewById(R.id.btn3)
        val addParam:Button=findViewById(R.id.btn4)
        val addHeader:Button=findViewById(R.id.btn5)
        btn1.setOnClickListener({
            Request_Json()
        })
        imagebtn.setOnClickListener({
            Request_Image()
        })
        stringbtn.setOnClickListener({
            Request_String()
        })
        addParam.setOnClickListener({
            Add_Post_parameter()
        })
        addHeader.setOnClickListener({
            Add_JSONArrayRequest()
        })
    }

    private fun Request_Json() {

        val view:TextView=findViewById(R.id.ViewBox)

        val queue= Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/fe8f5fec-dfc4-4568-8422-d48bb6cf1f8d"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener<JSONObject> { response ->
                view.isVisible = true
                view.text = response.toString()

            },
            Response.ErrorListener { error ->
                view.text = "Can't load request"

            })
        // Add JsonRequest to the RequestQueue
        queue.add(jsonObjectRequest)
    }

    private fun Request_String() {
        val view:TextView=findViewById(R.id.ViewBox)

        val queue= Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/f932aef0-d747-40d6-862d-ea3cf99d853a"
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                view.isVisible = true
                view.text = response

            },
            Response.ErrorListener { error ->
                view.text = "Can't load request"
                Log.d("Cant manage request", error.toString())

            })
        // Add StringRequest to the RequestQueue
        queue.add(stringRequest)
    }

    //####### (3) Request Image  ########/
    private fun Request_Image()
    {

        val image:ImageView=findViewById(R.id.image2)
        val queue= Volley.newRequestQueue(this)
        val mImageURLString="https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_960_720.jpg"
        val imageRequest = ImageRequest(
            mImageURLString, // Image URL
            Response.Listener<Bitmap> { response ->
                image.setImageBitmap(response)

            },
            250, // Image width
            250, // Image height
            ImageView.ScaleType.CENTER_CROP, // Image scale type
            Bitmap.Config.RGB_565, //Image decode configuration
            Response.ErrorListener() { // Error listener
                Response.ErrorListener { error ->

                    Toast.makeText(this,"Can't manage request",Toast.LENGTH_LONG).show()
                    Log.d("Cant manage request", error.toString())

                }
            }
        );
        // Add ImageRequest to the RequestQueue
        queue.add(imageRequest);
    }

    private fun Add_Post_parameter()
    {
        Toast.makeText(this,"Adding Post Parameter",Toast.LENGTH_LONG).show()

        val view: TextView =findViewById(R.id.ViewBox)
        val queue= Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/cc1eb953-b35f-49b0-b20e-e43232921464"

        val params = HashMap<String,String>()
        params["name"] = "Zeeshan Aziz"
        params["Class"] = "BSE-7B"
        params["Reg_No"] = "FA18-BSE-080"
        val jsonObject = JSONObject(params as Map<*, *>)

        // Volley post request with parameters
        val PostParam = JsonObjectRequest(
            Request.Method.POST,
            url,
            jsonObject,
            Response.Listener { response ->
                view.text = "Response: $response"

            },
            Response.ErrorListener{error->
                // Error in request
                view.text = "Volley error: $error"

            })
        // Add the volley post request to the request queue
        queue.add(PostParam)

    }


    private fun Add_JSONArrayRequest() {

        Toast.makeText(this, "Adding Request Headers", Toast.LENGTH_LONG).show()
    }
}