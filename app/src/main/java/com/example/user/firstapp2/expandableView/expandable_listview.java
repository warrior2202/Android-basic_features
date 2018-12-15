package com.example.user.firstapp2.expandableView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.user.firstapp2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class expandable_listview extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);

        expandableListView = findViewById(R.id.mainexpandableview);
        expandableListDetail= com.example.user.expandable_list_view.dataExp.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

        expandableListAdapter = new customAdapter(this,expandableListTitle,expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);



    }
}
