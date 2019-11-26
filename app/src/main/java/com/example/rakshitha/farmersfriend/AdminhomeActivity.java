package com.example.rakshitha.farmersfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdminhomeActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);
        Button createevent = findViewById(R.id.createevent);
        Button viewregistration = findViewById(R.id.viewreg);
        createevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminhomeActivity.this,Detailsdb.class);
                startActivity(i);
            }
        });

        viewregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminhomeActivity.this,ViewRegistrations.class);
                startActivity(intent);
            }
        });



    }
}
