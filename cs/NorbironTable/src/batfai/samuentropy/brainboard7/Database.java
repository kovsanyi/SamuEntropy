package batfai.samuentropy.brainboard7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanyi on 2016.10.27..
 */

public class Database extends SQLiteOpenHelper{
    private static final String DB_NAME = "norbirontable";
    private static final int DB_VERSION = 1;
    SQLiteDatabase database;
    Cursor cursor;

    public Cursor getResult(String sql){
        database = this.getReadableDatabase();
        cursor = database.rawQuery(sql, null);
        return cursor;
    }

    public Cursor getLastResult(){
        return cursor;
    }

    public Database(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database = db;
    }
}
