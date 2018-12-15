package com.example.user.firstapp2.firstpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.user.firstapp2.R;

public class signuppage extends AppCompatActivity {
    private Button Signup;
    private EditText Edtemail,Edtfirst,Edtlast,Edtnum;
    private String stremail,strpwd,strfirst,strlast,strnum;
    private RadioButton male,female;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_signuppage);

    }



}
