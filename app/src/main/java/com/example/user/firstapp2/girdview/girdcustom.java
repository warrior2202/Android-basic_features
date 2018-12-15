package com.example.user.firstapp2.girdview;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.firstapp2.R;

public class girdcustom extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;

    int[] imagesfol= {R.drawable.sampe1,R.drawable.sample2,R.drawable.sample3,R.drawable.sample4,R.drawable.sample5,R.drawable.sample6,R.drawable.sample7,R.drawable.sample8};
    String[] carsname = {"acura","alfaRomeo","astonmartin.","audi.","bentley","bmw.","Bugatti.","Buick"};

    public girdcustom(Context context){
        this.context = context;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }













    @Override
    public int getCount() {
        return imagesfol.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return imagesfol[i];
    }

    @Override
    public View getView(int i, View converview, ViewGroup parent) {
        converview = layoutInflater.inflate(R.layout.singlegirdview, null);
        ImageView imagview = converview.findViewById(R.id.cuustomimgviewgird);
        TextView txtaview = converview.findViewById(R.id.customtextviewgird);
        imagview.setImageResource(imagesfol[i]);
        txtaview.setText(carsname[i]);






        return converview;
    }
}



