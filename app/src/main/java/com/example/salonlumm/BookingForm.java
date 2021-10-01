package com.example.salonlumm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salonlumm.model.AppointModel;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BookingForm extends AppCompatActivity {


    EditText enterDate;
    EditText enterTime;
    EditText enterName;
    EditText enterBranch;
    Button btnSave;

    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);

        enterDate = findViewById(R.id.add_date);
        enterTime = findViewById(R.id.add_time);
        enterName = findViewById(R.id.add_appointment_for);
        enterBranch = findViewById(R.id.add_branch);

        btnSave = findViewById(R.id.appoint_submit);

        btnView = findViewById(R.id.view_appoint);

        AppointModel appointModel = new AppointModel();


        btnSave.setOnClickListener(view->{
            HashMap<String, Object> map = new HashMap<>();
            map.put("enterDate", enterDate.getText().toString());
            map.put("enterTime", enterTime.getText().toString());
            map.put("enterName", enterName.getText().toString());
            map.put("enterBranch",enterBranch.getText().toString());
            FirebaseDatabase.getInstance().getReference().child("appointModel").push()
                    .setValue(map).addOnSuccessListener(success -> {
                enterDate.setText("");
                enterTime.setText("");
                enterName.setText("");
                enterBranch.setText("");

                Toast.makeText(this, "Details Inserted Successfully!", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(fail -> {
                Toast.makeText(this, "Details Not Inserted !!", Toast.LENGTH_SHORT).show();
                ;
            });

        });

        btnView.setOnClickListener(view->{
            Intent intent = new Intent(this,DisplayAppointment.class);

            String date = enterDate.getText().toString();
            String time = enterTime.getText().toString();
            String name = enterName.getText().toString();
            String branch = enterBranch.getText().toString();




            startActivity(intent);
        });


    }
}












