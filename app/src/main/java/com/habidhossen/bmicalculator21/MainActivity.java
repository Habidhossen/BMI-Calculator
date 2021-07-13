package com.habidhossen.bmicalculator21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton calculateBtn;
    private ImageView aboutBtn;
    private TextView currentAge, currentWeight, currentHeight;
    private LinearLayout male, female;
    private SeekBar heightSeekbar;
    private ImageView incrementAge, decrementAge, incrementWeight, decrementWeight;
    /*declare variable*/
    int intWeight = 60;
    int intAge = 27;
    int currentProgress;
    String intProgress = "150";
    String typeofUser = "0";
    String weight2 = "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*finding all id from xml file*/
        calculateBtn = findViewById(R.id.calculateBtnId);
        aboutBtn = findViewById(R.id.aboutBtnId);
        currentAge = findViewById(R.id.currentAgeId);
        currentHeight = findViewById(R.id.heightDisplayId);
        currentWeight = findViewById(R.id.currentWeightId);
        male = findViewById(R.id.maleId);
        female = findViewById(R.id.femaleId);
        heightSeekbar = findViewById(R.id.heightSeekbarId);
        incrementAge = findViewById(R.id.incrementAgeId);
        decrementAge = findViewById(R.id.decrementAgeId);
        incrementWeight = findViewById(R.id.incrementWeightId);
        decrementWeight = findViewById(R.id.decrementWeightId);

        /*male button click or unclick*/
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_bg_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_bg_not_focus));
                typeofUser = "Male";

            }
        });
        /*female button click or unclick*/
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_bg_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_bg_not_focus));
                typeofUser = "Female";

            }
        });

        /*Working on SeekBar*/
        heightSeekbar.setMax(200);
        heightSeekbar.setProgress(150);
        heightSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                intProgress = String.valueOf(currentProgress);
                currentHeight.setText(intProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*Age increment*/
        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intAge = intAge + 1;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);

            }
        });
        /*Age decrement*/
        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intAge = intAge - 1;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);

            }
        });
        /*Weight increment*/
        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intWeight = intWeight + 1;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);

            }
        });
        /*Weight decrement*/
        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intWeight = intWeight - 1;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);

            }
        });
        /*Working on calculate button*/
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (typeofUser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender", Toast.LENGTH_SHORT).show();
                } else if (intProgress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Height", Toast.LENGTH_SHORT).show();
                } else if (intAge == 0 || intAge < 0) {
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (intWeight == 0 || intWeight < 0) {
                    Toast.makeText(getApplicationContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    //pass data one activity to another activity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("height", intProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);

                }
            }
        });
        /*Working on about button*/
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

}