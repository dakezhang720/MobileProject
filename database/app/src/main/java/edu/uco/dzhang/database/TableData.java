package edu.uco.dzhang.database;

import android.provider.BaseColumns;

/**
 * Created by xifeidanhu on 10/22/2015.
 */
public class TableData {
    public TableData(){

    }
    public static abstract class TableInfo implements BaseColumns{

        public static final String DATABASE = "Data";
        public static final String TABLE = "table";
        public static final String TITLE = "Title";
        public static final String DATE = "Date";
        public static final String TIME = "time";

    }
}
