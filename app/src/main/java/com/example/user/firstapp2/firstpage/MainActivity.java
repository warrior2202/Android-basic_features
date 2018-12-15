package com.example.user.firstapp2.firstpage;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.firstapp2.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button Login, Signp;
    private EditText TxtEmailID, TxtPwd;
    private String stremail, strpwd;
    private TextView helpme;
    private CheckBox checkBox;
    public static final String pres_name = "PresFile";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";
    public static final String isdatasaved ="savekey";


    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        componentsid();
        sharedPreferences =  getSharedPreferences(pres_name, Context.MODE_PRIVATE);



    }

    public void componentsid() {
        Login = findViewById(R.id.btnLogin);
        Signp = findViewById(R.id.btnSignup);
        TxtEmailID = findViewById(R.id.edtTxtEmailID);
        TxtPwd = findViewById(R.id.edtTxtPwd);
        helpme = findViewById(R.id.helpTxtClick);
        checkBox = findViewById(R.id.checkbox_rem);




        helpme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qwerty = new Intent(MainActivity.this,help.class);
                startActivity(qwerty);
            }
        });

        Signp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agh = new Intent(MainActivity.this,signuppage.class);
                startActivity(agh);
            }
        });



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stremail = TxtEmailID.getText().toString();
                strpwd = TxtPwd.getText().toString();

                if (emailValidator(stremail)) {
                    if (isValidPassword(strpwd)) {
                        if(checkBox.isChecked())
                        {         String email =stremail;
                                  String password = strpwd;

                                  SharedPreferences.Editor editor = sharedPreferences.edit();

                                  editor.putString(Email,email);
                                  editor.putString(Password,password);
                                  editor.putBoolean(isdatasaved,true);
                                  editor.commit();

                        }else{
                            sharedPreferences.edit().clear().apply();


                        }
                        Intent xyz = new Intent(MainActivity.this, loginout.class);
                        startActivity(xyz);
                        Toast.makeText(MainActivity.this, "Your Email id is " + stremail + " & Password is " + strpwd, Toast.LENGTH_LONG).show();

                    } else {
                        TxtPwd.setError("your password isnt strong enough");
                    }
                } else {
                    TxtEmailID.setError("enter a valid email id");
                    TxtPwd.setError("your password isn't strong enough");
                }




            }
        });

    }


    public static boolean isValidPassword(String password) {

        Matcher matcher = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,20})").matcher(password);
        return matcher.matches();
    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


}


