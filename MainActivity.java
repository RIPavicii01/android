package com.example.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart,btnEnd;
    RadioButton rdoCal,rdoTime;
    CalendarView calendar;
    TimePicker timepicker;
    TextView tvYear,tvMonth,tvDay,tvMin,tvHour;
    int sYear,sMonth,sDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer=findViewById(R.id.chronometer);
        btnStart=findViewById(R.id.btnStart);
        rdoCal=findViewById(R.id.rdoCal);
        rdoTime=findViewById(R.id.rdoTime);
        calendar=findViewById(R.id.calendar);
        timepicker=findViewById(R.id.timepicker);
        btnEnd=findViewById(R.id.btnEnd);
        tvYear=findViewById(R.id.tvYear);
        tvMonth=findViewById(R.id.tvMonth);
        tvDay=findViewById(R.id.tvDay);
        tvHour=findViewById(R.id.tvHour);
        tvMin=findViewById(R.id.tvMin);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int iyear, int i1month, int i2day) {
                sYear = iyear;
                sMonth = i1month+1;
                sDay=i2day;
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.GREEN);
                tvYear.setText(Integer.toString(sYear));
                tvMonth.setText(Integer.toString(sMonth));
                tvDay.setText(Integer.toString(sDay));
                tvHour.setText(Integer.toString(timepicker.getCurrentHour()));
                tvMin.setText(Integer.toString(timepicker.getCurrentMinute()));
            }
        });
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.VISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.VISIBLE);
            }
        });

    }
}