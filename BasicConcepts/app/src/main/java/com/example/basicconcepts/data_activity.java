package com.example.basicconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class data_activity extends AppCompatActivity {
    TextView name,pass,email,gender,courses,dob,country;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        name=findViewById(R.id.nametext);
        pass=findViewById(R.id.passtext);
        email=findViewById(R.id.emailtext);
        gender=findViewById(R.id.gendertext);
        courses=findViewById(R.id.coursestext);
        dob=findViewById(R.id.dobtext);
        country=findViewById(R.id.countrytxt);


        Intent intent=getIntent();
        String str = intent.getStringExtra("name");
        String str2 = intent.getStringExtra("email");
        String str3 = intent.getStringExtra("pass");
        String str4 = intent.getStringExtra("gender");
        String str5 = intent.getStringExtra("courses");
        String strdob = intent.getStringExtra("dob");
        String strcont = intent.getStringExtra("country");
        name.setText("Name : "+str);
        pass.setText("Password: "+str3);
        email.setText("Email : "+str2);
        gender.setText("Gender : "+str4);
        courses.setText("Courses : "+str5);
        dob.setText("DOB : "+strdob);
        country.setText("Country : "+strcont);

    }
}