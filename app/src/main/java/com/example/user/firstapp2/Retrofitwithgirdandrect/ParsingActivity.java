package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.firstapp2.R;

public class ParsingActivity extends AppCompatActivity {

    ImageView malebtn,femalebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_parsing );
        malebtn = (ImageView) findViewById( R.id.malebtm );
        femalebtn = (ImageView) findViewById( R.id.femaleBtn );
        malebtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab = new Intent( ParsingActivity.this,ParsingRetrofitActivity.class );
                ab.putExtra( "Gender","m" );
                startActivity( ab );
            }


        } );
        femalebtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(ParsingActivity.this,ParsingRetrofitActivity.class);
                abc.putExtra( "Gender","f" );
                startActivity( abc );
            }
        } );
    }
}
