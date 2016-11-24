package com.example.jennykuma.peticularme;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.view.Menu;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

public class CreateProfile extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText petBirthday;
    private String[] breeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

        Button imageGallery = (Button)findViewById(R.id.addProfPic_btn);
        TextView addProfilePic = (TextView)findViewById(R.id.addProfPic_text);
        TextView petInfo = (TextView)findViewById(R.id.pet_info);

        EditText petName = (EditText)findViewById(R.id.pet_name);
        EditText petBirthday = (EditText)findViewById(R.id.pet_birthday);
        RadioButton petMale = (RadioButton)findViewById(R.id.radioMale);
        RadioButton petFemale = (RadioButton)findViewById(R.id.radioFemale);
        TextView genderLabel = (TextView)findViewById(R.id.gender_label);
        TextView breedLabel = (TextView)findViewById(R.id.breed_label);
        EditText petDescription = (EditText)findViewById(R.id.pet_description);

        addProfilePic.setTypeface(roboto);
        petInfo.setTypeface(roboto);
        petName.setTypeface(roboto);
        petBirthday.setTypeface(roboto);
        petMale.setTypeface(roboto);
        petFemale.setTypeface(roboto);
        genderLabel.setTypeface(roboto);
        breedLabel.setTypeface(roboto);
        petDescription.setTypeface(roboto);

        imageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateProfile.this, ImageGallery.class));
            }
        });

        getBirthday();
        getBreed();
    }

    private void getBirthday(){
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById();
        setDateTimeField();
    }

    private void findViewsById(){
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
    public void onClick(View view){
        if(view == petBirthday){
            datePickerDialog.show();
        }
    }

    public void getBreed(){
        this.breeds = new String[]{"Alaskan Malamute", "American Eskimo Dog", "Beagle", "Dachshund", "English Cocker Spaniel",
                                    "Pomeranian", "Yorkshire Terrier"};

        Spinner breedSpinner = (Spinner)findViewById(R.id.breed_list);
        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, breeds);
        breedSpinner.setAdapter(breedAdapter);
        breedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
