package com.example.jennykuma.peticularme;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

        TextView uhOh = (TextView)findViewById(R.id.uhOh_msg);
        TextView noProfile = (TextView)findViewById(R.id.noProfile_msg);
        Button createProfile = (Button)findViewById(R.id.createProfile_btn);

        uhOh.setTypeface(roboto);
        noProfile.setTypeface(roboto);
        createProfile.setTypeface(roboto);

        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, CreateProfile.class));
            }
        });
    }
}
