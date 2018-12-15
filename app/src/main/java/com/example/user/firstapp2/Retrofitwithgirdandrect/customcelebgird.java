package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.firstapp2.R;
import com.example.user.firstapp2.Retrofitwithgirdandrect.BWcelebmore;

import java.util.List;


public class customcelebgird extends BaseAdapter {
    private Context context;
    List<BWcelebmore> BWCelebListmore;
    ImageView imageView;


    public customcelebgird(Context context, List<BWcelebmore> BWCelebListmore) {
        this.context = context;
        this.BWCelebListmore = BWCelebListmore;
    }


    @Override
    public int getCount() {
        return BWCelebListmore.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gird;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        if(view==null){
            gird = new View( context );
            gird = layoutInflater.inflate( R.layout.single_celeb_img,null);
            imageView = gird.findViewById( R.id.single_celebimg );
            String imageurl2 = BWCelebListmore.get(i).getImage_url();
            Glide.with( context ).load(imageurl2).into( imageView );


        }

        else{
            gird = view;
        }

        return gird;
    }
}
