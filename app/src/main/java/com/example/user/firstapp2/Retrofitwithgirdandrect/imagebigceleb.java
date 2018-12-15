package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.bumptech.glide.Glide;
import com.example.user.firstapp2.R;
import static com.example.user.firstapp2.Retrofitwithgirdandrect.nxtParingActivity.BWcelebmoreList;
public class imagebigceleb extends AppCompatActivity {
   private String TAG = imagebigceleb.class.getSimpleName();
    private Context context;
    String getit;
    private String id;
    ImageView imageView123;
    ViewPager viewPager;
    customswipeadater adater;
 public static Integer position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_imagebigceleb );position = getIntent().getIntExtra( "takeit",0 );
//        viewPager = (ViewPager)findViewById( R.id.view_pager );
//        adater = new customswipeadater(imagebigceleb.this);
//        viewPager.setAdapter( adater );

        id =getIntent().getStringExtra( "waah" );
        imageView123 = (ImageView)findViewById( R.id.idCelebImageView );
        getit = getIntent().getStringExtra( "url" );
        Log.e( TAG, "onCreate: getit" );
        Glide.with( imagebigceleb.this ).load( getit ).into( imageView123 );
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        View view = getSupportActionBar().getCustomView();
        TextView textView = (TextView) view.findViewById( R.id.sethere );
        textView.setText( BWcelebmoreList.get( position).getId() );
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.action_bar_forward);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton2.setClickable( true );

                if(position==0) {
                    Toast.makeText( imagebigceleb.this, "U R ON THE FIRST IMAGE ", Toast.LENGTH_LONG ).show();
                    imageButton.setClickable( false );
                }else {
                    position = position - 1;
                    String urltrail = BWcelebmoreList.get( position ).getImage_url();
                    Glide.with( imagebigceleb.this ).load( urltrail ).into( imageView123 );
                    View view = getSupportActionBar().getCustomView();
                    TextView textView = (TextView) view.findViewById( R.id.sethere );
                    textView.setText( BWcelebmoreList.get( position).getId() );
                    }
                    }

        });

       // ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.action_bar_forward);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setClickable( true );

                if(position ==BWcelebmoreList.size()-1) {
                    Toast.makeText( imagebigceleb.this, " have reached last image", Toast.LENGTH_LONG ).show();

                    imageButton2.setClickable( false );


                }else {
                    position = position + 1;
                    String urltrail = BWcelebmoreList.get( position ).getImage_url();
                    Glide.with( imagebigceleb.this ).load( urltrail ).into( imageView123 );
                    View view = getSupportActionBar().getCustomView();
                    TextView textView = (TextView) view.findViewById( R.id.sethere );
                    textView.setText( BWcelebmoreList.get( position).getId() );
                }


                }


        });
    }
}

