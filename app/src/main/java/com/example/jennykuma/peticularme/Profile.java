package com.example.jennykuma.peticularme;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

        TextView fullName = (TextView)findViewById(R.id.profile_fullName);
        TextView birthday = (TextView)findViewById(R.id.profile_birthday);
        TextView gender = (TextView)findViewById(R.id.profile_gender);
        TextView breed = (TextView)findViewById(R.id.profile_breed);
        TextView description = (TextView)findViewById(R.id.profile_description);

        fullName.setTypeface(roboto);
        birthday.setTypeface(roboto);
        gender.setTypeface(roboto);
        breed.setTypeface(roboto);
        description.setTypeface(roboto);

        Button bottomSheet = (Button)findViewById(R.id.share);
        bottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, BottomSheet.class));
            }
        });

    }
}
