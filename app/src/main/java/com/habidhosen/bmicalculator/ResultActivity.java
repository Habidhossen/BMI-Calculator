package com.habidhosen.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ResultActivity extends AppCompatActivity {

    /*declare variable*/
    private FloatingActionButton backBtn;
    private TextView bmiDisplay, categoryDisplay;
    private ImageView resultImageView;
    private String height;
    private String weight;
    private float floatHeight, floatWeight, floatBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*getting intent from mainActivity*/
        Intent intent = getIntent();

        /*finding all id*/
        backBtn = findViewById(R.id.backBtnId);
        bmiDisplay = findViewById(R.id.bmiDisplayId);
        categoryDisplay = findViewById(R.id.categoryDisplayId);
        resultImageView = findViewById(R.id.resultImageViewId);

        /*getting height, weight data from mainActivity*/
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        /*converting height weight string to float*/
        floatHeight = Float.parseFloat(height);
        floatWeight = Float.parseFloat(weight);
        //converting height cm to meter
        floatHeight = floatHeight / 100;
        //calculate bmi
        floatBmi = floatWeight / (floatHeight * floatHeight);
        //output formatter like(18.000000 to 18.00)
        bmiDisplay.setText(String.format("%.2f",floatBmi));

        /*BMI condition check*/
        if(floatBmi < 15)
        {
            categoryDisplay.setText("Very severely underweight");
            categoryDisplay.setTextColor(getResources().getColor(R.color.low_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);

        }
        else if(floatBmi<16 && floatBmi>15)
        {
            categoryDisplay.setText("Severely underweight");
            categoryDisplay.setTextColor(getResources().getColor(R.color.low_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);

        }
        else if(floatBmi<18.5 && floatBmi>16)
        {
            categoryDisplay.setText("Underweight");
            categoryDisplay.setTextColor(getResources().getColor(R.color.low_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);
        }
        else if(floatBmi<25 && floatBmi>18.5 )
        {
            categoryDisplay.setText("Normal");
            categoryDisplay.setTextColor(getResources().getColor(R.color.normal_category));
            resultImageView.setImageResource(R.drawable.ic_okay);
        }
        else if(floatBmi <30 && floatBmi>25)
        {
            categoryDisplay.setText("Overweight");
            categoryDisplay.setTextColor(getResources().getColor(R.color.high_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);
        }
        else if(floatBmi<35 && floatBmi>30)
        {
            categoryDisplay.setText("Obese Class I");
            categoryDisplay.setTextColor(getResources().getColor(R.color.high_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);
        }
        else if(floatBmi<40 && floatBmi>40)
        {
            categoryDisplay.setText("Obese Class II");
            categoryDisplay.setTextColor(getResources().getColor(R.color.high_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);
        }
        else
        {
            categoryDisplay.setText("Obese Class III");
            categoryDisplay.setTextColor(getResources().getColor(R.color.high_category));
            resultImageView.setImageResource(R.drawable.ic_not_okay);
        }

        /*Working on back button*/
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
