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

    //TABLES
    public static final String EVENT_TABLE_NAME = "events";
    public static final String COMMITEE_TABLE_NAME= "commitees";
    public static final String MEMBER_TABLE_NAME= "members";

    //ID COLUMN
    public static final String ID= "id";
    public static final String NAME= "name";

    //EVENT TABLE COLUMNS
    public static final String EVENT_LOGO = "logo";
    public static final String EVENT_DESCRIPTION = "description";
    public static final String EVENT_TIMINGS = "timings";
    public static final String EVENT_LOCATION = "location";
    public static final String EVENT_HEAD_ID = "head_id";
    public static final String EVENT_RULES = "rules";

    //COMMITEE TABLE COLUMNS
    public static final String COM_RESPONSIBILITIES = "";

    //MEMBER TABLE COLUMNS
    public static final String MEM_COMMITEE_ID = "commitee_id";
    public static final String MEM_EVENT_ID = "event_id";
    public static final String MEM_CONTACT_NUM = "contact_number";
    public static final String MEM_CONTACT_MAIL = "contact_mail";

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
