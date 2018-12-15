package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.firstapp2.R;

import static android.support.constraint.Constraints.TAG;
import static com.example.user.firstapp2.Retrofitwithgirdandrect.nxtParingActivity.BWcelebmoreList;
//import static com.example.user.firstapp2.Retrofitwithgirdandrect.imagebigceleb.textView;


public class customswipeadater extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public customswipeadater(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return BWcelebmoreList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int i) {
        layoutInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View item_view = layoutInflater.inflate( R.layout.swipe_layout, container, false );
        ImageView imageView = (ImageView) item_view.findViewById( R.id.idCelebImageView );
     //   textView.setText( BWcelebmoreList.get( i ).getId() );
        String imageurl = BWcelebmoreList.get( i ).getImage_url();
        Glide.with( context ).load( imageurl ).into( imageView );
        container.addView( item_view );
        return imageView;

    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (LinearLayout)object );

    }
}
