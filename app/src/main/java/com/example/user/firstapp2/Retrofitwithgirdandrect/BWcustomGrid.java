package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.firstapp2.R;
import com.example.user.firstapp2.Retrofitwithgirdandrect.BWceleb;

import java.util.List;

public class BWcustomGrid extends BaseAdapter {
    private Context context;
    List<BWceleb> BWcelebList;
    ImageView imageView;

    public BWcustomGrid(Context context, List<BWceleb> BWcelebList) {
        this.context = context;
        this.BWcelebList = BWcelebList;
    }

    @Override
    public int getCount() {
        return BWcelebList.size();
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        if(view==null){
            grid = new View( context );
            grid=inflater.inflate( R.layout.bollywood_gird_single,null );

            TextView txtview = grid.findViewById( R.id.gird_text );
            imageView  = grid.findViewById( R.id.gird_image );
            txtview.setText( BWcelebList.get(i).getName() );
            String imageurl = BWcelebList.get( i ).getProfile_pic();


            Glide.with(context).load( imageurl ).into( imageView );

        }else{grid = view;}
        return grid;
    }
}
