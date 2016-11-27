package com.example.jennykuma.peticularme;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    public void openBottomSheet (View v) {

        View view = getLayoutInflater ().inflate (R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView)view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView)view.findViewById(R.id.txt_facebook);
        TextView txtOpen = (TextView)view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView)view.findViewById(R.id.txt_uninstall);

        final Dialog mBottomSheetDialog = new Dialog (Profile.this,
                R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView (view);
        mBottomSheetDialog.setCancelable (true);
        mBottomSheetDialog.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow ().setGravity (Gravity.BOTTOM);
        mBottomSheetDialog.show ();


        txtBackup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this,"Clicked E-mail",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtDetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this,"Clicked Facebook",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this,"Clicked Open",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtUninstall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this,"Clicked Print",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
    }
}
