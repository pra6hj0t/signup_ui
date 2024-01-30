package com.example.basicconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String gender="";
    Button signup_btn,clear_btn;
    EditText name_edittxt,email_edittxt,pass_edittxt,about_edittxt;
    RadioGroup genderRadioGroup;
    RadioButton malebtn,femalebtn,otherbtn;
    CheckBox javaCheck,pythonCheck,androidCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findingViews();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();

                String name=name_edittxt.getText().toString();
                String email=email_edittxt.getText().toString();
                String pass=pass_edittxt.getText().toString();
                String about=about_edittxt.getText().toString();
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
                    courses+="Java ";
                }
                if(pythonCheck.isChecked()){
                    courses+="Python ";
                }
                if(androidCheck.isChecked()){
                    courses+="Android ";
                }
                Log.w("Name",name);
                Log.w("Email",email);
                Log.w("Password",pass);
                Log.w("About",about);
                Log.w("Gender",gender);
                Log.w("Courses",courses);

                Toast.makeText(MainActivity.this, "Got The Data", Toast.LENGTH_SHORT).show();

            }

        });
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edittxt.setText("");
                email_edittxt.setText("");
                pass_edittxt.setText("");
                about_edittxt.setText("");

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

    }
}