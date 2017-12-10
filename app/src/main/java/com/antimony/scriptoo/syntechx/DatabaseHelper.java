package com.antimony.scriptoo.syntechx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by antimony on 12/6/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "syntechxdb";
    public static final int DBVERSION = 1;


    public DatabaseHelper(Context context){
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //KUCH TOH
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //KUCH TOH
    }
}
