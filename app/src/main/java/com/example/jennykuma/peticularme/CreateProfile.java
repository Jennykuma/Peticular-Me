package com.example.jennykuma.peticularme;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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
import android.widget.Toast;
import android.app.Activity;

import org.w3c.dom.Text;

public class CreateProfile extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText petBirthday;
    private String[] breeds;

    private TextView addProfPic_text;// = (EditText)findViewById(R.id.addProfPic_text);
    private Button addProfPic_btn;// = (Button) findViewById(R.id.addProfPic_btn);
    private View addPic_rect;
    private View separator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");


        //Button imageGallery = (Button)findViewById(R.id.addProfPic_btn);
        TextView addProfilePic = (TextView)findViewById(R.id.addProfPic_text);
        TextView petInfo = (TextView)findViewById(R.id.pet_info);

        addProfPic_text = (TextView)findViewById(R.id.addProfPic_text);
        addProfPic_btn = (Button) findViewById(R.id.addProfPic_btn);
        addPic_rect = (View) findViewById(R.id.addPicture_rectangle);
        separator = (View) findViewById(R.id.rectShadow);

        EditText petName = (EditText)findViewById(R.id.pet_name);
        EditText petBirthday = (EditText)findViewById(R.id.pet_birthday);
        RadioButton petMale = (RadioButton)findViewById(R.id.radioMale);
        RadioButton petFemale = (RadioButton)findViewById(R.id.radioFemale);
        TextView genderLabel = (TextView)findViewById(R.id.gender_label);
        TextView breedLabel = (TextView)findViewById(R.id.breed_label);
        EditText petDescription = (EditText)findViewById(R.id.pet_description);

        addProfPic_text.setTypeface(roboto);
        petInfo.setTypeface(roboto);
        petName.setTypeface(roboto);
        petBirthday.setTypeface(roboto);
        petMale.setTypeface(roboto);
        petFemale.setTypeface(roboto);
        genderLabel.setTypeface(roboto);
        breedLabel.setTypeface(roboto);
        petDescription.setTypeface(roboto);

        /*imageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateProfile.this, BottomSheet.class));
            }
        });*/

        getBirthday();
        getBreed();

        Button createProfile = (Button)findViewById(R.id.createProfile_btn);
        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateProfile.this,
                        "Profile has been created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateProfile.this, Profile.class));
            }
        });
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
    public void onClickBtn(View view){
        //dispatchTakePictureIntent();
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Profile Picture");
        alertDialog.setMessage("Take a profile photo or choose from gallery?");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Camera",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dispatchTakePictureIntent();
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Gallery            ",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //BitmapDrawable bd = new BitmapDrawable(getResources(), imageBitmap);
            addProfPic_btn.setVisibility(View.GONE);
            addProfPic_text.setVisibility(View.GONE);
            separator.setVisibility(View.INVISIBLE);
            //addPic_rect.setBackground(bd);
            RoundedBitmapDrawable roundDrawable = RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);
            roundDrawable.setCircular(true);
            addPic_rect.setBackground(roundDrawable);
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
