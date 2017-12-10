package com.antimony.scriptoo.syntechx;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by antimony on 12/6/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {



    private static String DB_PATH = "/data/data/com.antimony.scriptoo.syntechx/databases/";
    private static String DB_NAME = "syntechx";
    private static int DBVERSION = 1;

    //EVENT COLUMNS
    public static String EVENT_NAME = "name";
    public static String EVENT_DESCRIPTION = "description";
    public static String EVENT_RULES = "rules";
    public static String EVENT_TIMINGS = "timings";
    public static String EVENT_LOCATION = "location";
    public static String EVENT_BACKGROUND = "background";
    public static String EVENT_DATE = "date";

    private SQLiteDatabase myDatabase;
    private final Context myContext;



    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DBVERSION);
        this.myContext = context;
    }

    public void createDatabase() throws IOException{
        //boolean dbExist = checkDatabase();
        boolean dbExist = false;

        if(dbExist){
            //kuch mat kar; database hai
        }else{
            this.getReadableDatabase();

            try {
                copyDataBase();
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }

    }

    private boolean checkDatabase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch (SQLiteException e){
            //db nahi hai
        }

        if(checkDB !=null){
            checkDB.close();
        }

        return checkDB !=null;
    }

    private void copyDataBase() throws IOException{

        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[4096];
        int length;
        while((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
        this.close();
    }

    public void openDatabase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDatabase != null){
            myDatabase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       //KUCH TOH
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //KUCH TOH
    }

    public Cursor getEvent(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM events WHERE id="+id+";";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

}
