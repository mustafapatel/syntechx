package com.antimony.scriptoo.syntechx;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class EventActivity extends AppCompatActivity {


    TextView description, rules, timings, location, heads;
    ImageView header;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);



        toolbar = (Toolbar) findViewById(R.id.event_page_toolbar);
        description = (TextView)findViewById(R.id.description_textview);
        rules= (TextView)findViewById(R.id.rules_textview);
        timings= (TextView)findViewById(R.id.timings_textview);
        location= (TextView)findViewById(R.id.location_textview);
        heads = (TextView)findViewById(R.id.heads_textview);
        header = (ImageView)findViewById(R.id.event_page_header);
        Intent i = getIntent();
        int eventid = i.getIntExtra("ID", 1);


//        setSupportActionBar(toolbar);



        //EVENT CODE
        DatabaseHelper dh = new DatabaseHelper(this);

        //CREATE
        try{
            dh.createDatabase();
        }catch (IOException ioe){
            throw new Error("Unable to create");
        }

        try{
            dh.openDatabase();
        }catch (SQLException sqle){
            throw sqle;
        }


        Cursor c = dh.getEvent(eventid+2);

        EventClass event = new EventClass(c);


        //SET ALL THE THINGS
        toolbar.setTitle(event.name);
        description.setText(event.description);
        rules.setText(event.rules);
        timings.setText(event.timing);
        location.setText(event.location);

        int resID = getResources().getIdentifier(c.getString(c.getColumnIndex(DatabaseHelper.EVENT_BACKGROUND)), "assets", getPackageName());
        header.setImageResource(resID);


    }




}
