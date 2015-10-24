package edu.uco.dzhang.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import edu.uco.dzhang.database.TableData.TableInfo;

/**
 * Created by xifeidanhu on 10/22/2015.
 */
public class DatabaseOperation extends SQLiteOpenHelper {

    public  static final int database_version = 1;
    public String CREAT_QUERY = "CREATE TABLE " + TableInfo.TABLE
            + " (" + TableInfo.TITLE
            + "TEXT, " + TableInfo.DATE
            + "TEXT, " + TableInfo.TIME + "TEXT);";

    public DatabaseOperation(Context context) {
        super(context, TableData.TableInfo.DATABASE, null, database_version);
        Log.d("Database", "Database is created.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation (DatabaseOperation dop, String title,String date, String time){

    }
}
