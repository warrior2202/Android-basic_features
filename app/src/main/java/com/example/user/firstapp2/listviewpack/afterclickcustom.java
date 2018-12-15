package com.example.user.firstapp2.listviewpack;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.firstapp2.R;

public class afterclickcustom extends AppCompatActivity {

    String[] carsname = {"Acura", "AlfaRomeo.", "Atonmartin.", "Audi.", "Bentley", "Bmw.", "Bugatti.", "Buick"};
    int[] carimages = {R.drawable.sampe1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4, R.drawable.sample5, R.drawable.sample6, R.drawable.sample7, R.drawable.sample8};
    String[] carsdetail = {"Acura is the luxury vehicle marque of Japanese automaker Honda. The brand was launched in the United States and Canada in March 1986, marketing luxury, performance, and high-performance vehicles",
    "Alfa Romeo Automobiles S.p.A. is a luxury car manufacturer, founded by Frenchman Alexandre Darracq as A.L.F.A. on 24 June 1910, in Milan. The brand is known for sporty vehicles and has been involved in car racing since 1911.",
    "Aston Martin Lagonda Limited is a British manufacturer of luxury sports cars and grand tourers. It was founded in 1913 by Lionel Martin and Robert Bamford",
    "Audi AG is a German automobile manufacturer that designs, engineers, produces, markets and distributes luxury vehicles. Audi is a member of the Volkswagen Group and has its roots at Ingolstadt, Bavaria, Germany.",
    "Bentley Motors Limited is a British manufacturer and marketer of luxury cars and SUVs—and a subsidiary of Volkswagen AG since 1998. Headquartered in Crewe, England, the company was founded as Bentley Motors Limited",
    "BMW is a German multinational company which currently produces luxury automobiles and motorcycles, and also produced aircraft engines until 1945. The company was founded in 1916 and has its headquarters in Munic",
    "Automobiles Ettore Bugatti was a French car manufacturer of high-performance automobiles, founded in 1909 in the then German city of Molsheim, Alsace by Italian-born Ettore Bugatti",
    "Buick (/ˈbjuːɪk/), formally the Buick Motor Division, is an automobile brand of the American manufacturer General Motors (GM). ... In 2015, Buick sold 1,231,941 vehicles, a record for the brand."};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterclickcustom);

        ImageView imgview = findViewById(R.id.imageView2);
        TextView txtview  = findViewById(R.id.textView);
        TextView txtdetails = findViewById(R.id.detailstxt);

        Intent abcdef = getIntent();
        int qwerty = abcdef.getIntExtra("keystoitem",0);
        imgview.setImageResource(carimages[qwerty]);
        txtview.setText(carsname[qwerty]);
        txtdetails.setText(carsdetail[qwerty]);






    }
}
