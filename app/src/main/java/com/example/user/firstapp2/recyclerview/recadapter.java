package com.example.user.firstapp2.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.firstapp2.R;
import com.example.user.firstapp2.Retrofitwithgirdandrect.recViewact;

import java.util.ArrayList;

public class recadapter extends RecyclerView.Adapter<recadapter.Myviewholer>  {

    private ArrayList<DataModelRecyclerVw> dataset;


    public static class Myviewholer extends RecyclerView.ViewHolder{
        TextView txtViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public Myviewholer(@NonNull View itemView) {
            super( itemView );
            this.txtViewName= itemView.findViewById( R.id.textViewNameCardLay );
            this.textViewVersion= itemView.findViewById( R.id.textViewVersion);
            this.imageViewIcon= itemView.findViewById( R.id.imageViewCardLay );

        }
    }
    public recadapter(ArrayList<DataModelRecyclerVw> data){
        this.dataset = data;

    }



    @NonNull
    @Override
    public Myviewholer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.cards_layout,viewGroup,false );
        view.setOnClickListener( recViewact.myonClickLisyener);
        Myviewholer myviewholer = new Myviewholer( view );
        return myviewholer;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholer holder, int listPosition) {

        TextView textViewName = holder.txtViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataset.get(listPosition).getName());
        textViewVersion.setText(dataset.get(listPosition).getVersion());
        imageView.setImageResource(dataset.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}






