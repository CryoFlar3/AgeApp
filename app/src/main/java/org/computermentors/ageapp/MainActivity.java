package org.computermentors.ageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button mFindAgeButton;
    private DatePicker mBirthDatePicker;
    private Calculate mCalculate = new Calculate();
    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBirthDatePicker = (DatePicker) findViewById(R.id.birthDatePicker);
        mFindAgeButton = (Button) findViewById(R.id.findAgeButton);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mFindAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker date = mBirthDatePicker;
                Date trueDate = mCalculate.Calculate2(date);
                String birth = mCalculate.Calculate(date);
                mYear = mCalculate.getYear(trueDate);
                mMonth = mCalculate.getMonth(trueDate);
                mDay = mCalculate.getDay(trueDate);

                startBirth(birth, mYear, mMonth, mDay);

            }
        });
    }

    private void startBirth (String date, int year, int month, int day){

        Intent intent = new Intent(this, BirthActivity.class);
        intent.putExtra("Birth", date);
        intent.putExtra("Year", year);
        intent.putExtra("Month", month);
        intent.putExtra("Day", day);
        startActivity(intent);
    }
}
