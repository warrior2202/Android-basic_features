package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.user.firstapp2.R;

import java.util.List;

public class customceleb extends RecyclerView.Adapter<customceleb.Myviewholder> {
    private Context context;
    public static String transfer;
    List<BWcelebmore> BWcelebmorelist;
    ImageView imageView;
    public static class Myviewholder extends RecyclerView.ViewHolder {
        ImageView imageViewicon;
        private List<BWcelebmore> dataset;
        public Myviewholder(@NonNull View itemView) {
            super( itemView );
            this.imageViewicon = itemView.findViewById( R.id.single_celebimg );
        }
    }
    public customceleb(Context context, List<BWcelebmore> BWcelebmorelist) {
        this.context = context;
        this.BWcelebmorelist = BWcelebmorelist;
    }
    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.single_celeb_img ,parent,false);
        Myviewholder myviewholder = new Myviewholder( view );
        return myviewholder;
    }
    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
        ImageView imageview = myviewholder.imageViewicon;
        String imageurl = BWcelebmorelist.get( i ).getImage_url();
        Glide.with( context ).load(imageurl).into(imageview);
        transfer = BWcelebmorelist.get( i ).getImage_url();
    }
    @Override
    public int getItemCount() {
        return BWcelebmorelist.size();
    }
}
