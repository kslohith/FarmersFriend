package com.example.rakshitha.farmersfriend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ShareActivity extends AppCompatActivity {

    ImageView s1, s2, s3, s4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);


        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ShareActivity.this, Detailsdb.class);
                i1.putExtra("url", "https://5.imimg.com/data5/OO/RY/MY-45687661/5042-d-john-deere-tractor-500x500.jpg");
                i1.putExtra("name","Tractor");
                startActivity(i1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(ShareActivity.this, Detailsdb.class);
                i2.putExtra("url", "https://5.imimg.com/data5/OY/UD/MY-381517/kartar-tractor-combined-harvester-500x500.jpg");
                i2.putExtra("name","Harvestor");
                startActivity(i2);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(ShareActivity.this, Detailsdb.class);
                i3.putExtra("url", "https://4.imimg.com/data4/DR/DY/MY-14166347/tractor-plough-250x250.jpg");
                i3.putExtra("name","Plough");
                startActivity(i3);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(ShareActivity.this, Detailsdb.class);
                i4.putExtra("url", "http://2.imimg.com/data2/CM/GY/MY-/hardman-plough-photo-500x-500x500.jpg");
                i4.putExtra("name","Drag");
                startActivity(i4);

            }
        });


    }
}
