package com.example.rakshitha.farmersfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CropPrediction extends AppCompatActivity {

    Button predict;
    EditText soil , ni , ph , k , dry;
    String msoil , mni , mph , mk , mdry;
    int a = 0;
    DatabaseReference mdatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_prediction);
        predict = findViewById(R.id.Predict);
        soil = findViewById(R.id.soil);
        ni = findViewById(R.id.nitrogen);
        ph = findViewById(R.id.phosphorous);
        k = findViewById(R.id.potassium);
        dry = findViewById(R.id.dry_matter);
        mdatabaseReference= FirebaseDatabase.getInstance().getReference("Params");

        Log.d( mdry, "onCreate:hey" );


        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a += 1;
                msoil = soil.getText().toString();
                mni = ni.getText().toString();
                mph = ph.getText().toString();
                mk = k.getText().toString();
                mdry = dry.getText().toString();

                String id = String.valueOf(a);

                Parameters parameters = new Parameters(msoil,mni,mph,mk,mdry);

                mdatabaseReference.child(id).setValue(parameters);
                startActivity(new Intent(CropPrediction.this,PredictResult.class));


            }
        });
    }
}
