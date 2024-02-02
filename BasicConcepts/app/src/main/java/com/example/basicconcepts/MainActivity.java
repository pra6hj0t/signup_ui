package com.example.basicconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String gender="";

    Button signup_btn,clear_btn;
    EditText name_edittxt,email_edittxt,pass_edittxt,about_edittxt,date_pick_btn;
    RadioGroup genderRadioGroup;
    RadioButton malebtn,femalebtn,otherbtn;
    CheckBox javaCheck,pythonCheck,androidCheck;
    Spinner spinner;

    String countryNames[]={

            "USA",
            "Canada",
            "India",
            "Australia",
            "Pakistan",
            "China"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findingViews();

         date_pick_btn.setOnClickListener(view->{
//            Toast.makeText(MainActivity.this,"Select DOB",Toast.LENGTH_SHORT).show();

            Calendar calendar = Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
             int month=calendar.get(Calendar.MONTH);
             int day=calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        // ye call hoga jab hum date ko pick kr lenge
                        date_pick_btn.setText(selectedDay+"/"+(selectedMonth+1)+"/"+selectedYear);


                        //Toast.makeText(MainActivity.this,"Year : "+ selectedYear +" Month : "+ selectedMonth +" Day : "+ selectedDay ,Toast.LENGTH_SHORT).show();


                    },
                    year,
                    month,
                    day
            );

            datePickerDialog.show();

        });

         ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countryNames);

         spinner.setAdapter(arrayAdapter);
        // spinner.setSelection(2);
         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(MainActivity.this,"Selected Country : "+countryNames[position],Toast.LENGTH_LONG).show();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();

                String name=name_edittxt.getText().toString();
                String email=email_edittxt.getText().toString();
                String pass=pass_edittxt.getText().toString();
                String about=about_edittxt.getText().toString();
                String dob=date_pick_btn.getText().toString();
                String country=spinner.getSelectedItem().toString();


                if (name.trim().equals("")){
                    name_edittxt.setError("Name is required");
                    return;
                }
                if(email.trim().equals("")){
                    email_edittxt.setError("Email is required");
                    return;
                }
                if(pass.trim().equals("")){
                  pass_edittxt.setError("Password is required");
                  return;
                }


                if(malebtn.isChecked()){
                    gender="Male";
                } if (femalebtn.isChecked()) {
                    gender="Female";
                }
                if (otherbtn.isChecked()){
                    gender="Other";
                }
                if(gender.equals("")){
//                    malebtn.setError("");
//                    femalebtn.setError("");
//                    otherbtn.setError("");
                    Toast.makeText(MainActivity.this,"Select Gender",Toast.LENGTH_SHORT).show();
                    return;
                }

                String courses=" ";
                if (javaCheck.isChecked()){
                    courses+="Java";
                }
                if(pythonCheck.isChecked()){
                    courses+=" Python";
                }
                if(androidCheck.isChecked()){
                    courses+=" Android ";
                }
                Log.w("Name",name);
                Log.w("Email",email);
                Log.w("Password",pass);
                Log.w("About",about);
                Log.w("Gender",gender);
                Log.w("Courses",courses);
                Log.w("Country",country);

                Toast.makeText(MainActivity.this, "Got The Data", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,data_activity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("pass",pass);
                intent.putExtra("gender",gender);
                intent.putExtra("courses",courses);
                intent.putExtra("dob",dob);
                intent.putExtra("country",country);
                startActivity(intent);

            }

        });
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edittxt.setText("");
                email_edittxt.setText("");
                pass_edittxt.setText("");
                about_edittxt.setText("");
                date_pick_btn.setText("");

//                if (gender.equals("Male")){
//                    malebtn.setChecked(false);
//                }
//                if (gender.equals("Female")){
//                    femalebtn.setChecked(false);
//                }
//                if (gender.equals("Other")){
//                    otherbtn.setChecked(false);
//                }

                malebtn.setChecked(false);
                femalebtn.setChecked(false);
                otherbtn.setChecked(false);
                javaCheck.setChecked(false);
                pythonCheck.setChecked(false);
                androidCheck.setChecked(false);

            }
        });


    }
    public void findingViews(){
        signup_btn=findViewById(R.id.signup_btn);
        clear_btn=findViewById(R.id.clear_btn);
        name_edittxt=findViewById(R.id.name_edittext);
        email_edittxt=findViewById(R.id.email_edittext);
        pass_edittxt=findViewById(R.id.password_edittext);
        about_edittxt=findViewById(R.id.about_edittext);
        genderRadioGroup=findViewById(R.id.gender_radiogroup);
        malebtn=findViewById(R.id.male_radiobutton);
        femalebtn=findViewById(R.id.female_radioButton);
        otherbtn=findViewById(R.id.other_radioButton);
        javaCheck=findViewById(R.id.java_checkBox);
        pythonCheck=findViewById(R.id.python_checkBox);
        androidCheck=findViewById(R.id.android_checkBox);
        date_pick_btn=findViewById(R.id.pick_dob);
        spinner=findViewById(R.id.country_spinner);

    }
}