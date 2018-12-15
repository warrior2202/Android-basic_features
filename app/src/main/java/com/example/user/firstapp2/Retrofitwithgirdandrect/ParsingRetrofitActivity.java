package com.example.user.firstapp2.Retrofitwithgirdandrect;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.widget.AdapterView;
import android.widget.GridView;
import android.app.ProgressDialog;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.firstapp2.R;
import com.example.user.firstapp2.rest.ApiClient;
import com.example.user.firstapp2.rest.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParsingRetrofitActivity extends AppCompatActivity {
    private String TAG =ParsingRetrofitActivity.class.getSimpleName();
    private String gender;
    GridView gird;
    SwipeRefreshLayout mSwipeRefreshLayout;
    List<BWceleb> BWCeleblist;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_parsing_retrofit );
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        gender = getIntent().getStringExtra( "Gender" );
        gird = findViewById(R.id.bWgird );
        check();
        mSwipeRefreshLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                check();
                mSwipeRefreshLayout.setRefreshing( false );
            }
        } );
//        if (isNetworkAvailable()){
//            Snackbar.make(gird,"ONLINE",Snackbar.LENGTH_LONG ).show();
//
//            showProgDialog();
//            getBWceleb();}
//        else {
//            Snackbar snackbar = Snackbar.make( gird,"offline",Snackbar.LENGTH_LONG);
//           // snackbar.setActionTextColor(Color.RED);
//            View sbView = snackbar.getView();
//            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//            textView.setTextColor(Color.YELLOW);
//
//
//         // sbView.setBackgroundColor( 16718362 );
//            snackbar.show();
//
//        }

    }
    private void showProgDialog(){
        pDialog = new ProgressDialog( ParsingRetrofitActivity.this );
        pDialog.setMessage( "please wait......." );
        pDialog.setCancelable( false );
        pDialog.show();
    }
    public void check(){
        if (isNetworkAvailable()){
            Snackbar.make(gird,"ONLINE",Snackbar.LENGTH_LONG ).show();

            showProgDialog();
            getBWceleb();}
        else {
            Snackbar snackbar = Snackbar.make( gird,"offline",Snackbar.LENGTH_LONG);
            // snackbar.setActionTextColor(Color.RED);
            View sbView = snackbar.getView();

           TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
           // textView.setBackgroundColor( getResources().getColor( R.color.colorAccent));
            textView.setTextAlignment( View.TEXT_ALIGNMENT_CENTER );



           sbView.setBackgroundColor( getResources().getColor( R.color.colorAccent)  );

            snackbar.show();

        }

    }


    private void getBWceleb(){

        ApiInterface apiService = ApiClient.getClient().create( ApiInterface.class );
        Call<List<BWceleb>> call = apiService.getceleb( gender,"1" );

        call.enqueue( new Callback<List<BWceleb>>() {
            @Override
            public void onResponse(Call<List<BWceleb>> call, Response<List<BWceleb>> response) {
                if(pDialog.isShowing())
                    pDialog.dismiss();

                BWCeleblist=response.body();
                if(BWCeleblist != null){
                    Log.d(TAG,"nmmer of celeb received" + BWCeleblist.size());
                    BWcustomGrid adapter = new BWcustomGrid( ParsingRetrofitActivity.this,BWCeleblist );
                    gird.setAdapter( adapter );

                    gird.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                           // Toast.makeText(ParsingRetrofitActivity.this,"you clicked"+ BWCeleblist.get(i).getName(),Toast.LENGTH_LONG).show();
                            Intent abcd = new Intent( ParsingRetrofitActivity.this,nxtParingActivity.class );
                            abcd.putExtra( "Great",BWCeleblist.get( i ).getId() );
                            startActivity( abcd );
                        }
                    } );
                }
            }

            @Override
            public void onFailure(Call<List<BWceleb>> call, Throwable t) {
                Log.e(TAG,t.toString());
                Toast.makeText( getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG ).show();


            }
        } );

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
