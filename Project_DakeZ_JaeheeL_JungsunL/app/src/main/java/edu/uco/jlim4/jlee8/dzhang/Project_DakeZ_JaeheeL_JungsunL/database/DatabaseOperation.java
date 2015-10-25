package edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.database.TableData.TableInfo.*;

/**
 * Created by DakeZhang on 10/22/2015.
 */
public class DatabaseOperation extends SQLiteOpenHelper {

    public  static final int database_version = 1;
    public String CREAT_QUERY = "CREATE TABLE " + TABLE
            + " (" + TITLE
            + "TEXT, " + STARTDATE
            + "TEXT, " + STARTTIME + "TEXT);";

    public DatabaseOperation(Context context) {
        super(context, DATABASE, null, database_version);
        Log.d("Database", "Database is created.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_QUERY);
        Log.d("Table", "Table is created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void pushInformation (DatabaseOperation dop, String title, String memo, String date, String time){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, title);
        cv.put(MEMO, memo);
        cv.put(STARTDATE, date);
        cv.put(STARTTIME, time);
        long k = SQ.insert(TABLE, null, cv);
        Log.d("Database", "One raw inserted.");
    }
}
