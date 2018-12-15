package com.example.user.firstapp2.listviewpack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.firstapp2.R;
import com.example.user.firstapp2.girdview.customviewapp;

public class customlistmain extends AppCompatActivity {
    ListView listviewcustfdf;

    int[] carimages = {R.drawable.sampe1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4, R.drawable.sample5, R.drawable.sample6, R.drawable.sample7, R.drawable.sample8};
    String[] carsname = {"acura", "alfaRomeo.", "astonmartin.", "audi.", "bentley", "bmw.", "Bugatti.", "Buick"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistmain);
        listviewcustfdf = findViewById(R.id.mainlist5);
        customviewapp abcd = new customviewapp(customlistmain.this);
        listviewcustfdf.setAdapter(abcd);
        listviewcustfdf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent abcdef = new Intent(getApplicationContext(),afterclickcustom.class);
                abcdef.putExtra("keystoitem",i);
                startActivity(abcdef);

            }
        });




    }
}
