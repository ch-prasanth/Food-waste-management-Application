package com.example.food_waste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class donate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] items={"Veg","Non-Veg","Anything"};
    EditText date,time,feed_count,loc,res;
    String dateee,spin;
    Spinner sp;
    Button sub;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Spinner sp=findViewById(R.id.type);
        date=findViewById(R.id.date);
        time=findViewById(R.id.time);
        feed_count=findViewById(R.id.count);
        loc=findViewById(R.id.location);
        res=findViewById(R.id.res);
        sp=findViewById(R.id.type);
        sub=findViewById(R.id.sub);
        calendar=Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
                date.setText(dateee);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(donate.this,"details submited successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int
                            dayOfMonth) {
                        dateee = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year);
                    }
                },year,month,dayOfMonth);
        datePickerDialog.show();
    }
    public void showTimePicker() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                String selectedTime = timeFormat.format(calendar.getTime());
                time.setText(selectedTime);
            }
        }, hour, minute, false);

        timePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spin=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

