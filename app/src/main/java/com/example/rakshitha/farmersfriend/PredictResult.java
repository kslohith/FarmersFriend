package com.example.rakshitha.farmersfriend;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PredictResult extends AppCompatActivity {

    private RequestQueue requestQueue;
    TextView textView1,textViewnew, third;
    private StringRequest request;
    private String URL = "http://192.168.43.98:5000";
    String msoil , mni , mph , mk , mdry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predict_result);
        msoil = getIntent().getStringExtra("soil");
        Log.e( msoil, "onCreate: msoil--------------------------------------------");
        mni = getIntent().getStringExtra("ni");
        mph = getIntent().getStringExtra("ph");
        mk = getIntent().getStringExtra("k");
        mdry = getIntent().getStringExtra("dry");
        textView1 = findViewById(R.id.text2);
        textViewnew= findViewById(R.id.text3);
        third=findViewById(R.id.text4);
        requestQueue = Volley.newRequestQueue(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        request = new StringRequest(Request.Method.GET, URL , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    String flag = response;
                    Log.e(flag, "onResponse:api call");
                    String[] crop_to_grow = flag.split(",");
                    textView1.setText(crop_to_grow[1]);
                    textViewnew.setText(crop_to_grow[2]);
                    third.setText(crop_to_grow[3]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Please check your internet connection .",Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Log.e( "", "getParams: inside method=======================================" );
                HashMap<String, String> hashMap = new HashMap<String, String>();
                Log.e( msoil, "getParams: avmois");
                hashMap.put("AvMoisture",msoil);
                hashMap.put("AvDryMatter",mdry);
                hashMap.put("nitrogen",mni);
                hashMap.put("phosphorus",mph);
                hashMap.put("potassium",mk);


                return hashMap;
            }

        };
        requestQueue.add(request);

    }
}
