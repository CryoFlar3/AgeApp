package org.computermentors.ageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BirthActivity extends AppCompatActivity {

    private TextView mAgeTextView;
    private String mDate;
    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAgeTextView = (TextView) findViewById(R.id.ageTextView);

        Intent intent = getIntent();
        mDate = intent.getStringExtra("Birth");
        mYear = intent.getIntExtra("Year", 0);
        mMonth = intent.getIntExtra("Month", 0);
        mDay = intent.getIntExtra("Day", 0);


        mAgeTextView.setText("Your birth date is " + mDate + ". You are " + mYear + " years, " + mMonth + " months, and " + mDay + " days old!");
    }

}
