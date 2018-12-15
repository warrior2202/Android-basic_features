package com.example.user.firstapp2.firstpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.firstapp2.R;

import static com.example.user.firstapp2.firstpage.MainActivity.isdatasaved;
import static com.example.user.firstapp2.firstpage.MainActivity.pres_name;

public class splash extends AppCompatActivity {
    private static int splash_timeot = 3000;
    public static final String pres_name = "PresFile";






    SharedPreferences sharedPreferences;


    @RequiresApi(api = 28)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_splash);
        sharedPreferences =  getSharedPreferences(pres_name, Context.MODE_PRIVATE);



        Handler abc = new Handler();
        abc.postDelayed(new Runnable() {
            boolean isdata = sharedPreferences.getBoolean(isdatasaved, false);

            @Override
            public void run() {
                   if(isdata){
                      Intent in = new Intent(splash.this,loginout.class);
                    startActivity(in);
                    finish();
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                }else{
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
           }


        }
        }, splash_timeot);
    }
    }

