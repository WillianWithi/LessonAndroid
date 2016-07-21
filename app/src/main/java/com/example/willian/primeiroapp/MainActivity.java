package com.example.willian.primeiroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.willian.primeiroapp.controller.AppController;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button start;
    TextView textView;
    RequestQueue requestQueue;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.btn_start);
        textView = (TextView) findViewById(R.id.textView);
        url = "http://validate.jsontest.com/?json=%7B%22key%22:%22value%22%7D";

        requestQueue = Volley.newRequestQueue(this);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try{
                                    textView.setText(response.getString("parse_time_nanoseconds"));
                                }catch (JSONException e){
                                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }

                            }

                        }, new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                            }

                       });
                AppController.getInstance().addToRequestQueue(jsonObjectRequest);
            }
        });


    }
}
