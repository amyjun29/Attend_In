package com.example.attend_in;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn_checkIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning variables
        btn_checkIn = findViewById(R.id.checkInButton);


        //click listeners
        btn_checkIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                final String API = "1f576b29567c4c9493df858dd9c285c5";
                final String URL_PREFIX = "https://api.ipgeolocation.io/ipgeo?apiKey=";
                String url = URL_PREFIX + API;

                //JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, );

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                });
                queue.add(stringRequest);
            }


        });



    }

}

