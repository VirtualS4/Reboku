package com.reboku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ImageView menuNews = findViewById(R.id.btn_news);
        ImageView menuProgress = findViewById(R.id.btn_progress);
        ImageView menuInfo = findViewById(R.id.btn_info);
        ImageView menuTanamanKu = findViewById(R.id.btn_tanaman_ku);
        TextView menuAboutUs = findViewById(R.id.btn_about_us);


        menuNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNews= new Intent(getApplicationContext(), News.class);
                startActivity(goToNews);
            }
        });

        menuProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToProgress= new Intent(getApplicationContext(), ProgressReboisasi.class);
                startActivity(goToProgress);
            }
        });

        menuInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToInformasi= new Intent(getApplicationContext(), InformationCenter.class);
                startActivity(goToInformasi);
            }
        });

        menuTanamanKu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMyPlant= new Intent(getApplicationContext(), MyPlant.class);
                startActivity(goToMyPlant);
            }
        });

        menuAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAboutUs= new Intent(getApplicationContext(), AboutUs.class);
                startActivity(goToAboutUs);
            }
        });



    }




}