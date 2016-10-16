package com.example.mason.ontime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewClassInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_class_input);

        MultiSelectionSpinner spinner=(MultiSelectionSpinner)findViewById(R.id.input1);

        List<String> list = new ArrayList<String>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        spinner.setItems(list);

        final SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.OnTime_Prefs), Context.MODE_PRIVATE);


        Button finish = (Button)findViewById(R.id.button2);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = " ";
                String buildingName = " ";
                String classTime = " ";

                EditText classInput = (EditText) findViewById(R.id.className);
                if (classInput.getText().length() == 0)
                    classInput.setError("Please enter a valid class name");
                else
                    className = classInput.getText().toString();

                EditText buildingInput = (EditText) findViewById(R.id.buildingName);
                if (buildingInput.getText().length() == 0)
                    buildingInput.setError("Please enter a valid building abbreviation");
                else {
                    buildingName = buildingInput.getText().toString().trim();
                    buildingName = buildingName.replaceAll(" ", "+");

                }
                EditText timeInput = (EditText) findViewById(R.id.classTime);
                if (timeInput.getText().length() == 0)
                    timeInput.setError("Please enter a valid time");
                else
                    classTime = timeInput.getText().toString();

                TextView errorText = (TextView) findViewById(R.id.textView3);

                MultiSelectionSpinner daysInput = (MultiSelectionSpinner) findViewById(R.id.input1);
                String dayOfClass = daysInput.getSelectedItemsAsString();
                if (dayOfClass.equals(""))
                    errorText.setError("Please select the days of class");

                if (className.equals(" ") || buildingName.equals(" ") || classTime.equals(" ") || dayOfClass.equals("")) {

                } else {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    Set<String> daysOfClass = sharedPref.getStringSet("daysOfClass", new HashSet<String>());
                    Set<String> classNames = sharedPref.getStringSet("classNames", new HashSet<String>());
                    Set<String> buildingNames = sharedPref.getStringSet("buildingNames", new HashSet<String>());
                    Set<String> classTimes = sharedPref.getStringSet("classTimes", new HashSet<String>());

                    editor.putStringSet(dayOfClass ,daysOfClass);
                    editor.putStringSet(className, classNames);
                    editor.putStringSet(buildingName, buildingNames);
                    editor.putStringSet(classTime, classTimes);

                    int count = 0;
                    if(ScheduleInput.secondClass.equals(" "))
                        ScheduleInput.secondClass = className;
                    else {
                        ScheduleInput.thirdClass = className;

                    }

                    if(ScheduleInput.secondBuilding.equals(" "))
                        ScheduleInput.secondBuilding = buildingName;
                    else {
                        ScheduleInput.thirdBuilding = buildingName;
                    }

                    editor.commit();

                    Intent myIntent = new Intent(NewClassInput.this, Main2Activity.class);
                    startActivity(myIntent);
                    finish();


                }
            }
        });

        Button addAnother = (Button)findViewById(R.id.button3);
        addAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = " ";
                String buildingName = " ";
                String classTime = " ";

                EditText classInput = (EditText)findViewById(R.id.className);
                if(classInput.getText().length() == 0)
                    classInput.setError("Please enter a valid class name");
                else
                    className = classInput.getText().toString();

                EditText buildingInput = (EditText) findViewById(R.id.buildingName);
                if(buildingInput.getText().length() == 0)
                    buildingInput.setError("Please enter a valid building abbreviation");
                else {
                    buildingName = buildingInput.getText().toString().trim();
                    buildingName = buildingName.replaceAll(" ", "+");

                }
                EditText timeInput = (EditText) findViewById(R.id.classTime);
                if(timeInput.getText().length() == 0)
                    timeInput.setError("Please enter a valid time");
                else
                    classTime = timeInput.getText().toString();

                TextView errorText = (TextView)findViewById(R.id.textView3);

                MultiSelectionSpinner daysInput = (MultiSelectionSpinner) findViewById(R.id.input1);
                String dayOfClass = daysInput.getSelectedItemsAsString();
                if(dayOfClass.equals(""))
                    errorText.setError("Please select the days of class");

                if(className.equals(" ") || buildingName.equals(" ") || classTime.equals(" ") || dayOfClass.equals("")) {

                }
                else {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    Set<String> daysOfClass = sharedPref.getStringSet("daysOfClass", new HashSet<String>());
                    Set<String> classNames = sharedPref.getStringSet("classNames", new HashSet<String>());
                    Set<String> buildingNames = sharedPref.getStringSet("buildingNames", new HashSet<String>());
                    Set<String> classTimes = sharedPref.getStringSet("classTimes", new HashSet<String>());

                    editor.putStringSet(dayOfClass ,daysOfClass);
                    editor.putStringSet(className, classNames);
                    editor.putStringSet(buildingName, buildingNames);
                    editor.putStringSet(classTime, classTimes);

                    editor.commit();
                    int count = 0;
                    if(ScheduleInput.secondClass.equals(" "))
                        ScheduleInput.secondClass = className;
                    else {
                        ScheduleInput.thirdClass = className;

                    }

                    if(ScheduleInput.secondBuilding.equals(" "))
                        ScheduleInput.secondBuilding = buildingName;
                    else {
                        ScheduleInput.thirdBuilding = buildingName;
                    }

                    Intent myIntent = new Intent(NewClassInput.this, NewClassInput.class);
                    startActivity(myIntent);
                    finish();


                }


            }
        });




    }

}
