package dolinski.andrzej.zaliczenie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrz_000 on 2015-06-13.
 */
public class RaisedTaskDB extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "TaskActivity";

    private static final String TABLE_NAME = "tasks";
    private static final String SUMMARY = "summary";
    private static final String DESCRIPTION = "description";
    private static final String DATE = "date";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "("
            + "_ID INTEGER PRIMARY KEY, "
            + SUMMARY + " TEXT,"
            + DESCRIPTION + " TEXT,"
            + DATE + " TEXT)";

    public RaisedTaskDB(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nop
    }

    public void saveData(String summary, String description, String date) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUMMARY, summary);
        values.put(DESCRIPTION, description);
        values.put(DATE, date);

        db.insert(TABLE_NAME, null, values);
    }

    public List<TaskEntry> readData() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                SUMMARY,
                DESCRIPTION,
                DATE,
        };

        Cursor c = db.query(TABLE_NAME, projection, null, null, null, null, null);

        List<TaskEntry> tasks = new LinkedList<>();

        int summaryColumnIndex = c.getColumnIndex(SUMMARY);
        int descriptionColumnIndex = c.getColumnIndex(DESCRIPTION);
        int dateColumnIndex = c.getColumnIndex(DATE);

        while (c.moveToNext()) {
            tasks.add(new TaskEntry(c.getString(summaryColumnIndex), c.getString(descriptionColumnIndex), c.getString(dateColumnIndex)));
        }

        return tasks;
    }
}
