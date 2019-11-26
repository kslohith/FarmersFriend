package com.example.rakshitha.farmersfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterEvent extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    EditText name , usn , branch;
    String names , usns , branchs;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Registrations");
        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        usn = findViewById(R.id.usn);
        branch = findViewById(R.id.branch);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names = name.getText().toString();
                usns = usn.getText().toString();
                branchs = branch.getText().toString();


                String id = mDatabaseReference.push().getKey();
                String event_name = getIntent().getStringExtra("name");

                Register register = new Register(names,usns,branchs,event_name);
                mDatabaseReference.child(id).setValue(register).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(RegisterEvent.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });






    }
}
