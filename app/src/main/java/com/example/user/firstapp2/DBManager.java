package com.example.user.firstapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.user.firstapp2.dbhelper._ID;

public class DBManager {
    private dbhelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new dbhelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(dbhelper.SUBJECT, name);
        contentValue.put(dbhelper.DESC, desc);
        database.insert(dbhelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]
                {dbhelper._ID,dbhelper.SUBJECT, dbhelper.DESC };

        Cursor cursor = database.query(dbhelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper.SUBJECT, name);
        contentValues.put(dbhelper.DESC, desc);
        int i = database.update(dbhelper.TABLE_NAME, contentValues, dbhelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(dbhelper.TABLE_NAME, dbhelper._ID + "=" + _id, null);
    }

}

