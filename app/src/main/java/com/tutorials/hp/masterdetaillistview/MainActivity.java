package com.tutorials.hp.masterdetaillistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.tutorials.hp.masterdetaillistview.mData.SpaceCraftsCollection;
import com.tutorials.hp.masterdetaillistview.mListView.CustomAdapter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        ListView lv= (ListView) findViewById(R.id.lv);
        CustomAdapter adapter=new CustomAdapter(this, SpaceCraftsCollection.getSpaceCrafts());
        lv.setAdapter(adapter);

    }


}
