package com.example.mason.ontime;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.OnTime_Prefs), Context.MODE_PRIVATE);
        String name = sharedPref.getString("Name", "DEFAULT");
        TextView welcome = (TextView) findViewById(R.id.welcomeField);
        welcome.setText("Welcome, " + name + "!");

        TextView date = (TextView) findViewById(R.id.textView10);
        date.setText("October 16, 2016");

        TextView firstC = (TextView) findViewById(R.id.textView6);
        firstC.setText(ScheduleInput.firstClass);



        TextView firstT = (TextView) findViewById(R.id.firstTime);
        firstT.setText(ScheduleInput.firstBuilding);
        TextView secT = (TextView) findViewById(R.id.textView9);
        secT.setText(ScheduleInput.secondBuilding);


        TextView thirdT = (TextView) findViewById(R.id.textView12);
        thirdT.setText(ScheduleInput.thirdBuilding);

        TextView secondC = (TextView) findViewById(R.id.textView8);
        TextView thirdC = (TextView) findViewById(R.id.textView11);

        secondC.setText(ScheduleInput.secondClass);
        thirdC.setText(ScheduleInput.thirdClass);







    }
}
