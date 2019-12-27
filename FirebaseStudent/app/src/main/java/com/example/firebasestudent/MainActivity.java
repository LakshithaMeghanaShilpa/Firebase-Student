package com.example.firebasestudent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText name,USN,specialization,dept;
    private Button send,dataview;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");
//        studentsList = new ArrayList<>();


        name=(EditText)findViewById(R.id.name);
        USN=(EditText)findViewById(R.id.USN);
        specialization=(EditText)findViewById(R.id.specialization);
        dept=(EditText)findViewById(R.id.dept);
        send =(Button) findViewById(R.id.send);
        dataview = (Button)findViewById(R.id.dataview);


        dataview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this,DataRetrieved.class);
                startActivity(next);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Data has been sent",Toast.LENGTH_LONG).show();
                addstudents();

            }
        });

    }



    public void addstudents(){

        String studentName= name.getText().toString();
        String studentUSN= USN.getText().toString();
        String studentSpecialization= specialization.getText().toString();
        String studentDept= dept.getText().toString();

        if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentUSN) && !TextUtils.isEmpty(studentSpecialization) && !TextUtils.isEmpty(studentDept)){
            String id = databaseReference.push().getKey();
            students student = new students(id,studentName,studentUSN,studentSpecialization,studentDept);
            databaseReference.child(id).setValue(student);
            name.setText("");
            USN.setText("");
            dept.setText("");
            specialization.setText("");


        }
        else {
            Toast.makeText(MainActivity.this,"Please type all the details",Toast.LENGTH_LONG).show();
        }


    }
}
