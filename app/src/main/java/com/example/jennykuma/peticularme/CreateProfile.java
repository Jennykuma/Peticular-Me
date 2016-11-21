package com.example.jennykuma.peticularme;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.view.Menu;
import android.view.View.OnClickListener;

public class CreateProfile extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    private EditText petBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

        TextView addProfilePic = (TextView)findViewById(R.id.addProfPic_text);
        TextView petInfo = (TextView)findViewById(R.id.pet_info);

        EditText petName = (EditText)findViewById(R.id.pet_name);
        petBirthday = (EditText)findViewById(R.id.pet_birthday);


        addProfilePic.setTypeface(roboto);
        petInfo.setTypeface(roboto);
        petName.setTypeface(roboto);
        petBirthday.setTypeface(roboto);

        getBirthday();

    }

    private void getBirthday(){
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewById();
        setDateTimeField();
    }

    private void findViewById(){
        petBirthday = (EditText)findViewById(R.id.pet_birthday);
        petBirthday.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField(){
        petBirthday.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                petBirthday.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View v){
    }
}
