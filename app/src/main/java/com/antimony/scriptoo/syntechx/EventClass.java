package com.antimony.scriptoo.syntechx;

import android.database.Cursor;

import com.antimony.scriptoo.syntechx.DatabaseHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by antimony on 12/10/17.
 */

public class EventClass {

    public String name, rules, description, timing, date, location, background;
    Map map;

    public int getEventBackgroundResource(){
        if (background.equals("admad.jpg"))
            return R.drawable.admad;
        else if (background.equals("swiftkeys.jpg"))
            return R.drawable.swiftkeys;
        else if (background.equals("affiche.jpg"))
            return R.drawable.affiche;
        else
            return R.drawable.dcode;
    }

    public EventClass(String name, String background){
        this.name = name;
        this.background = background;
    }

    public EventClass(Cursor c){

        c.moveToFirst();
        name = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_NAME));
        rules = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_RULES));
        description = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_DESCRIPTION));
        timing = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_TIMINGS));
        date = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_DATE));
        location = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_LOCATION));

        name = c.getString(c.getColumnIndex(DatabaseHelper.EVENT_NAME));

    }

}
