package edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.database;

import android.provider.BaseColumns;

import java.sql.Date;

/**
 * Created by DakeZhang on 10/22/2015.
 */
public class TableData {
    public TableData(){

    }
    public static abstract class TableInfo implements BaseColumns{

        public static final String DATABASE = "Data";
        public static final String TABLE = "table";
        public static final String TITLE = "Title";
        public static final String MEMO = "Memo";
        //could save Date and Time together?
        public static final String STARTDATE = "Date";
        public static final String STARTTIME = "time";
        public static final String ENDDATE = "Date";
        public static final String ENDTIME = "time";
        public static final String LOCATION = "location";
        public static final String ADDRESS = "Address";
    }
}
