package com.example.user.firstapp2.Retrofitwithgirdandrect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import static com.example.user.firstapp2.Retrofitwithgirdandrect.customceleb.transfer;

import com.example.user.firstapp2.R;
import com.example.user.firstapp2.firstpage.MainActivity;
import com.example.user.firstapp2.rest.ApiClient;
import com.example.user.firstapp2.rest.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class nxtParingActivity extends AppCompatActivity  {
    private String TAG = nxtParingActivity.class.getSimpleName();
    private String id;
    public static List<BWcelebmore> BWcelebmoreList;
    private ProgressDialog pDialog;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_nxt_paring );
        id =getIntent().getStringExtra( "Great" );
        recyclerView = findViewById(R.id.gird_test );
        recyclerView.setHasFixedSize( true );
        layoutManager = new GridLayoutManager( this,2);
        recyclerView.setLayoutManager( layoutManager );
        getBWcelebmore();
        showProgDig();
    }

    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private nxtParingActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final nxtParingActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
    private void showProgDig(){
        pDialog = new ProgressDialog(nxtParingActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(true);
        pDialog.show();
    }
    private void getBWcelebmore () {
            ApiInterface apiservice = ApiClient.getClient().create( ApiInterface.class );
            Call<List<BWcelebmore>> call = apiservice.getcelebmore( id);
            call.enqueue( new Callback<List<BWcelebmore>>() {
                @Override
                public void onResponse(Call<List<BWcelebmore>> call, Response<List<BWcelebmore>> response) {
                    if (pDialog.isShowing())
                        pDialog.dismiss();
                    BWcelebmoreList = response.body();
                    if (BWcelebmoreList != null) {
                        Log.d( TAG, "photo revieeedf" );
                        customceleb abcder = new customceleb( nxtParingActivity.this, BWcelebmoreList );
                        recyclerView.setAdapter( abcder);
                        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                Intent abcdfghfgjkf = new Intent( nxtParingActivity.this,imagebigceleb.class );
                                abcdfghfgjkf.putExtra( "takeit",position );
                                abcdfghfgjkf.putExtra( "url",BWcelebmoreList.get(position).getImage_url() );
                                abcdfghfgjkf.putExtra( "waah",id );

                                startActivity( abcdfghfgjkf );
                            }
                            @Override
                            public void onLongClick(View view, int position) {
                            }
                        }));

                    }
                }

                @Override
                public void onFailure(Call<List<BWcelebmore>> call, Throwable t) {
                    Log.e( TAG, t.toString() );
                    Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG ).show();
                }
            } );
    }


}