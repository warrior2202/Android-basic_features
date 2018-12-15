package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.firstapp2.R;
import com.example.user.firstapp2.recyclerview.DataModelRecyclerVw;
import com.example.user.firstapp2.recyclerview.MyDataRecycler;
import com.example.user.firstapp2.recyclerview.recadapter;

import java.util.ArrayList;

public class recViewact extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private static RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModelRecyclerVw> data;
    public static View.OnClickListener myonClickLisyener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rec_viewact );
        myonClickLisyener = new MyOnClickListener( this );

        recyclerView = findViewById( R.id.my_recycler_view );
        recyclerView.setHasFixedSize( true );
        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setItemAnimator( new DefaultItemAnimator() );

        data = new ArrayList<DataModelRecyclerVw>();
        for (int i = 0; i < MyDataRecycler.nameArray.length; i++) {
            data.add( new DataModelRecyclerVw(
                    MyDataRecycler.nameArray[i],
                    MyDataRecycler.versionArray[i],
                    MyDataRecycler.id_[i],
                    MyDataRecycler.drawableArray[i]
            ) );

        }
        removedItems = new ArrayList<Integer>();
        adapter = new recadapter( data );
        recyclerView.setAdapter( adapter );
    }

    private static class MyOnClickListener implements View.OnClickListener{
        private final Context context;
        private MyOnClickListener(Context context){
            this.context = context;

    }


        @Override
        public void onClick(View v) {
            removeItem(v);

        }

        private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition( v );
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewname = viewHolder.itemView.findViewById( R.id.textViewNameCardLay );
            String selectedName = (String)textViewname.getText();
            int selectedItemId = -1;
            int i;
            for ( i =0; i < MyDataRecycler.nameArray.length; i++){
                if(selectedName.equals( MyDataRecycler.nameArray[i] )) {
                    selectedItemId = MyDataRecycler.id_[i];
                }


            }
            removedItems.add(selectedItemId);
            data.remove(selectedItemPosition);
            adapter.notifyItemRemoved(selectedItemPosition);
            }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu( menu);
        getMenuInflater().inflate( R.menu.menu_cardvw,menu );
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected( item );
        if(item.getItemId() == R.id.add_item){
            if(removedItems.size() != 0){
                addRemoveditemToList();
            }else {
                Toast.makeText( this,"nothings to add",Toast.LENGTH_LONG ).show();
            }
        }
        return true;
    }

    private void addRemoveditemToList() {
        data.add(removedItems.get(0), new DataModelRecyclerVw(
                MyDataRecycler.nameArray[removedItems.get(0)],
                MyDataRecycler.versionArray[removedItems.get(0)],
                MyDataRecycler.id_[removedItems.get(0)],
                MyDataRecycler.drawableArray[removedItems.get(0)]
        ));
        adapter.notifyItemInserted(removedItems.get(0));
        removedItems.remove(0);
    }


}
