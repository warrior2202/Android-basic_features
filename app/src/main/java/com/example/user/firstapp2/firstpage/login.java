package com.example.user.firstapp2.firstpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.firstapp2.Retrofitwithgirdandrect.ParsingActivity;
import com.example.user.firstapp2.R;
import com.example.user.firstapp2.basic_animation;
import com.example.user.firstapp2.expandableView.expandable_listview;
import com.example.user.firstapp2.girdview.gird_Finsl;
import com.example.user.firstapp2.listviewpack.customlistmain;
import com.example.user.firstapp2.Retrofitwithgirdandrect.recViewact;
import com.example.user.firstapp2.sqlite_db;

public class login extends AppCompatActivity {
    private Button mylistc;
    private Button myexp;
    private Button myrec;
    private Button myrecadv;
    private Button mybasanim;
    private Button mysqlitel;
    private Button mysqlite2;



    public  void girdViewon (View view){
        Intent abcdfgh = new Intent( login.this,gird_Finsl.class );
        startActivity( abcdfgh );

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);

        mylistc = findViewById(R.id.customlist);

        mylistc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab = new Intent(login.this,customlistmain.class);
                startActivity(ab);
            }
        });

        myexp = findViewById(R.id.expandable);
        myexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(login.this,expandable_listview.class);
                startActivity(abc);
            }
        });

        myrec = findViewById(R.id.Recycler__view);
        myrec.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abcd = new Intent( login.this,recViewact.class );
                startActivity( abcd );
            }
        } );

        myrecadv = findViewById( R.id.Recyclerviewadv );
        myrecadv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abcde = new Intent( login.this,ParsingActivity.class );
                startActivity( abcde );
            }
        } );

        mybasanim = findViewById( R.id.basicanimation );
        mybasanim.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abcdef = new Intent( login.this,basic_animation.class);
                startActivity( abcdef );
            }
        } );
        mysqlitel = findViewById( R.id.sqlite );
        mysqlitel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abcdefg = new Intent( login.this, sqlite_db.class );
                startActivity( abcdefg );
            }
        } );

//        mysqlite2 = findViewById( R.id.advsql );
//        mysqlite2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent abcdefgh = new Intent( login.this,advsqlite.class );
//                startActivity( abcdefgh );
//
//            }
//        } );






    }
}
