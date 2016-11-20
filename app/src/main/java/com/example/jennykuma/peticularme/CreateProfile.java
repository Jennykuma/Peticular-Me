package com.example.jennykuma.peticularme;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

        TextView addProfilePic = (TextView)findViewById(R.id.addProfPic_text);
        TextView petInfo = (TextView)findViewById(R.id.pet_info);

        addProfilePic.setTypeface(roboto);
        petInfo.setTypeface(roboto);
    }
}
