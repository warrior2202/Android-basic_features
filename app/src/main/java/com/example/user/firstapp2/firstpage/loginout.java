package com.example.user.firstapp2.firstpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.firstapp2.R;

import static com.example.user.firstapp2.firstpage.MainActivity.Email;
import static com.example.user.firstapp2.firstpage.MainActivity.isdatasaved;


public class loginout extends AppCompatActivity {

    private TextView myemailid;
    private String emailff;
    public static final String pres_name = "PresFile";
    SharedPreferences sharedPreferences;



    private  void initcomponent(){
        emailff = sharedPreferences.getString(Email,null);
        myemailid.setText(emailff);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_loginout);
        sharedPreferences = getSharedPreferences(pres_name, Context.MODE_PRIVATE);
        myemailid = findViewById(R.id.userEmail);
        initcomponent();
        }
        public void backMain(View view){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
            editor.putBoolean(isdatasaved,false);

            Intent intent = new Intent(loginout.this,MainActivity.class);
            startActivity(intent);
            finish();
    }
    public void loginacty(View view){
        Intent abc = new Intent(loginout.this,login.class);
        startActivity(abc);
    }






}
