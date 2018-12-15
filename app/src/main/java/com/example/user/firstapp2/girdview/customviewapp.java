package com.example.user.firstapp2.girdview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.firstapp2.R;

import java.util.Random;

public class customviewapp extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;

    int[] carimages = {R.drawable.sampe1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4, R.drawable.sample5, R.drawable.sample6, R.drawable.sample7, R.drawable.sample8};
    String[] carsname = {"acura", "alfaRomeo.", "astonmartin.", "audi.", "bentley", "bmw.", "Bugatti.", "Buick"};


    public customviewapp(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

    }


    @Override
    public int getCount() {
        return carimages.length;
    }

    @Override
    public Object getItem(int position) {
        return carimages[position];

    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = layoutInflater.inflate(R.layout.singlelistcustom, null);

        ImageView imgviewv = view.findViewById(R.id.imageView);
        TextView txtcis = view.findViewById(R.id.qwerty);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));


        imgviewv.setImageResource(carimages[position]);

        txtcis.setText(carsname[position]);
        txtcis.setBackgroundColor(color);


        return view;
    }


}
