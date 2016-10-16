package com.example.mason.ontime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = " ";
                String major = " ";
                String gradClass = " ";
                String living = " ";

                EditText userName = (EditText)findViewById(R.id.userName);
                if(userName.getText().length() == 0)
                    userName.setError("Please input a valid name");
                else
                    name = userName.getText().toString();
                EditText userMajor = (EditText)findViewById(R.id.userMajor);
                if(userMajor.getText().length() == 0)
                    userMajor.setError("Please input a valid major");
                else
                    major = userMajor.getText().toString();
                EditText userClass = (EditText)findViewById(R.id.userClass);
                if(userClass.getText().length() == 0)
                    userClass.setError("Please input a valid class");
                else
                    gradClass = userClass.getText().toString();
                EditText residence = (EditText)findViewById(R.id.residence);
                if(residence.getText().length() == 0)
                    residence.setError("Please input a valid residence");
                else
                    living = residence.getText().toString();

                if(name.equals(" ") || major.equals(" ") || gradClass.equals(" ") || living.equals(" ")) {

                }
                else {
                    SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.OnTime_Prefs), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Name", name);
                    editor.putString("Major", major);
                    editor.putString("Grad_Class", gradClass);
                    editor.putString("Residence", living);
                    editor.commit();

                    Intent myIntent = new Intent(MainActivity.this, ScheduleInput.class);
                    startActivity(myIntent);
                    finish();

                }


            }
        });


    }
}
