package com.example.rakshitha.farmersfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detailsdb extends AppCompatActivity {
    private EditText mitemPrice;
    private EditText mitemDescription, event_name , event_date;
    private Button submit;
    private DatabaseReference mDatabaseReference;
    String item_name , item_desc , item_price , item_url , item_url_my , item_name_my , date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsb);
        //mitemPrice = findViewById(R.id.item_price);
        mitemDescription = findViewById(R.id.item_description);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Items");
        //item_url_my = getIntent().getStringExtra("url");
        event_name = findViewById(R.id.item_name);
        submit = findViewById(R.id.add_event_button);
        event_date = findViewById(R.id.item_date);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item_name = event_name.getText().toString();
                item_desc = mitemDescription.getText().toString();
                date = event_date.getText().toString();
                //item_price = event_name.getText().toString();
                //item_url = item_url_my;

                String id = mDatabaseReference.push().getKey();

                Farmers farmers = new Farmers(item_name,item_desc,date);

                mDatabaseReference.child(id).setValue(farmers);
                startActivity(new Intent(Detailsdb.this,HomeActivity.class));


    }
});
    }
}
