package com.antimony.scriptoo.syntechx;

import android.database.Cursor;

import com.antimony.scriptoo.syntechx.DatabaseHelper;

/**
 * Created by antimony on 12/10/17.
 */

public class EventClass {

    public String name, rules, description, timing, date, location, header;

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
