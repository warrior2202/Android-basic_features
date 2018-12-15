package com.example.user.firstapp2.girdview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.user.firstapp2.R;

public class gird_Finsl extends AppCompatActivity {
    GridView girdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_gird__finsl );
        girdView = findViewById(R.id.girdviremmain);
        girdView.setAdapter(new girdcustom(this));


    }
}



