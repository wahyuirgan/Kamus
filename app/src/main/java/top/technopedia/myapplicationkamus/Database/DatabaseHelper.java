package top.technopedia.myapplicationkamus.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static top.technopedia.myapplicationkamus.Database.DatabaseContract.KamusColumns.*;
import static top.technopedia.myapplicationkamus.Database.DatabaseContract.TABLE_ENG_TO_INA;
import static top.technopedia.myapplicationkamus.Database.DatabaseContract.TABLE_INA_TO_ENG;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME         = "dbkamus";
    private static final int DATABASE_VERSION   = 1;

    public static String CREATE_TABLE_INA_TO_ENG = "create table "+TABLE_INA_TO_ENG+
            " ("+_ID+" integer primary key autoincrement, " +
            FIELD_KATA+" text not null, " +
            FIELD_ARTI+" text not null);";

    public static String CREATE_TABLE_ENG_TO_INA = "create table "+TABLE_ENG_TO_INA+
            " ("+_ID+" integer primary key autoincrement, " +
            FIELD_KATA+" text not null, " +
            FIELD_ARTI+" text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_INA_TO_ENG);
        db.execSQL(CREATE_TABLE_ENG_TO_INA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_INA_TO_ENG);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ENG_TO_INA);
        onCreate(db);
    }
}
