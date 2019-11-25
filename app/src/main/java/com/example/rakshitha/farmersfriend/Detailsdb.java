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
    private EditText mitemDescription;
    private Button submit;
    private DatabaseReference mDatabaseReference;
    String item_name , item_desc , item_price , item_url , item_url_my , item_name_my;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsb);
        mitemPrice = findViewById(R.id.item_price);
        mitemDescription = findViewById(R.id.item_description);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Items");
        item_url_my = getIntent().getStringExtra("url");
        item_name_my = getIntent().getStringExtra("name");
        submit = findViewById(R.id.add_event_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item_name = item_name_my;
                item_desc = mitemDescription.getText().toString();
                item_price = mitemPrice.getText().toString();
                item_url = item_url_my;

                String id = mDatabaseReference.push().getKey();

                Farmers farmers = new Farmers(item_name,item_desc,item_price,item_url);

                mDatabaseReference.child(id).setValue(farmers);
                startActivity(new Intent(Detailsdb.this,HomeActivity.class));


    }
});
    }
}
