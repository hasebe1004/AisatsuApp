package com.example.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;

    int hourOfDay2;
    int minuteOfDay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }


    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        hourOfDay2 = hourOfDay;
                        minuteOfDay2 = minute;
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Log.d("UI-PART", String.valueOf(hourOfDay2));
            if (hourOfDay2 >= 2 && hourOfDay2 <= 9 && minuteOfDay2 <= 59) {
                mTextView.setText("おはよう");

            } else if (hourOfDay2 >= 10 && hourOfDay2 <= 17 && minuteOfDay2 <= 59) {
                mTextView.setText("こんにちわ");
            } else if (((hourOfDay2 >= 18 && hourOfDay2 <= 24) || (hourOfDay2 >= 0 && hourOfDay2 <= 1)) && minuteOfDay2 <= 59) {
                mTextView.setText("こんばんわ");


            }
        }
        else if (v.getId() == R.id.button2) {
                showTimePickerDialog();
            }
        }
    }
