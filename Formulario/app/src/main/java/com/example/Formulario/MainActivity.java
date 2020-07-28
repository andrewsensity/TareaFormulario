package com.example.Formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.aplicacion2.R;
import com.google.android.material.textfield.TextInputEditText;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputEditText   name;
    TextInputEditText   date;
    String              getdate;
    TextInputEditText   phone;
    TextInputEditText   email;
    TextInputEditText   description;
    Button              btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name        = findViewById(R.id.etName);
        date        = findViewById(R.id.etDate);
        phone       = findViewById(R.id.etPhone);
        email       = findViewById(R.id.etEmail);
        description = findViewById(R.id.etDescription);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    String nameS            = name.getEditableText().toString();
                    String dateS            = date.getText().toString();
                    String phoneS           = phone.getText().toString();
                    String emailS           = email.getText().toString();
                    String descriptionStr   = description.getText().toString();

                    Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                    intent.putExtra("name",nameS);
                    intent.putExtra("date",dateS);
                    intent.putExtra("phone",phoneS);
                    intent.putExtra("email",emailS);
                    intent.putExtra("description",descriptionStr);
                    startActivity(intent);

            }
        });
    }

    public void showDatePickerDialog(View v) {
        pickerDialog getDate = new pickerDialog().newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String begin = "0";
                final int mesActual = month+1;
                String dayFormat = (day<10)?begin+String.valueOf(day):String.valueOf(day);
                String monthFormat = (month<10)?begin+String.valueOf(month):String.valueOf(month);
                final String dateSelect = dayFormat+"/"+(monthFormat)+"/"+year;
                getdate = dateSelect;
                date.setText(dateSelect);
            }

        });
        getDate.show(getSupportFragmentManager(), "datePicker");
    }

}
