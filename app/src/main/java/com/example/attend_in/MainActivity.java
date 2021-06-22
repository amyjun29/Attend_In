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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn_checkIn;
    EditText txt_studentID;


    //Upon opening the app
    //Gets the student's geolocation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //URL for API
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        final String API = "1f576b29567c4c9493df858dd9c285c5";
        final String URL_PREFIX = "https://api.ipgeolocation.io/ipgeo?apiKey=";
        final String URL_POSTFIX = "&ip=1.1.1.1&fields=geo";
        String url = URL_PREFIX + API + URL_POSTFIX;

        //Get JSON Object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //Assigning variables for latitude and longitude
                String lat = "";
                String longt = "";

                //Try Catch block for getting JSON object
                try {
                    lat = response.getString("latitude");
                    longt = response.getString("longitude");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, lat + " " + longt, Toast.LENGTH_SHORT).show();
            }
        },
                //Error listener

                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        //Add the request for geolocation on to the queue
        queue.add(request);


        //Check in Button
        btn_checkIn = findViewById(R.id.checkInButton);
        txt_studentID = (EditText) findViewById(R.id.studentID);

        btn_checkIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //Toast message to let the student know they're checked in
                String studentID = txt_studentID.getText().toString();
                Toast.makeText(MainActivity.this, studentID + " You're checked In. Thanks!", Toast.LENGTH_SHORT).show();

            }


        });





    }

}

