package com.example.food_waste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class edit_profile extends AppCompatActivity {
    ImageView img1,edim;
    EditText fname1,lname1,email1,dob1,gender1,cont1;
    Button sav_chang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        img1=findViewById(R.id.img1);
        edim=findViewById(R.id.edim);
        fname1=findViewById(R.id.fname1);
        lname1=findViewById(R.id.lname1);
        email1=findViewById(R.id.email1);
        dob1=findViewById(R.id.dob1);
        cont1=findViewById(R.id.cont1);
        sav_chang=findViewById(R.id.sav_chang);
        //img1=findViewById(R.id.img1);
        dob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

    }
    public void showDatePicker() {
        int year, month, day;
        String currentDate = dob1.getText().toString();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int monthOfYear, int dayOfMonth) {
                String selectedDate = String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, selectedYear);
                dob1.setText(selectedDate);
            }
        },year,month,day);
        datePickerDialog.show();
    }

}