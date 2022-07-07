package com.example.mareu.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.model.Reunion;
import com.example.mareu.service.ReunionApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddReunionActivity extends AppCompatActivity {



    @BindView(R.id.subjectTextLyt)
    TextInputLayout subjectInput;
    @BindView(R.id.placeTextLyt)
    TextInputLayout placeInput;
    @BindView(R.id.personTextLyt)
    TextInputLayout personInput;
    @BindView(R.id.timeText)
    TextView timeInput;

    DatePickerDialog.OnDateSetListener setListener;
    int hour, minute;
    private ReunionApiService mApiService;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_reunion);
        ButterKnife.bind(this);
        datePicker();
        mApiService = DI.getReunionApiService();
    }


    private void datePicker() {
        Calendar calendar = Calendar.getInstance();

        int selectedYear = calendar.get(Calendar.YEAR);
        int selectedMonth = calendar.get(Calendar.MONTH);
        int selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

// Date Select Listener.

        timeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddReunionActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar, setListener, selectedYear, selectedMonth, selectedDay);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }

        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                timePicker(date);


            }
        };

    }

    private void timePicker(String date) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeInput.setText(date + "  " + hour + ":" + minute);

            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    @OnClick(R.id.nextButton)
    void buttonNext() {
        Date newDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

        try {
            newDate = formatter.parse(timeInput.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Reunion reunion = new Reunion(
                subjectInput.getEditText().getText().toString(),
                newDate,
                placeInput.getEditText().getText().toString(),
                personInput.getEditText().getText().toString()
        );

        mApiService.createReunion(reunion);
        finish();
    }

}


