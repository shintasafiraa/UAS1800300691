package com.aa183.safira;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbfilm";
    public static final String TABLE_NAME = "tbfilm";
    public static final String COL_1 = "idfilm";
    public static final String COL_2 = "judul_film";
    public static final String COL_3 = "genre_film";
    public static final String COL_4 = "durasi_film";
    public static final String COL_5 = "sutradara_film";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (idfilm INTEGER PRIMARY KEY AUTOINCREMENT, judul_film TEXT, genre_film TEXT, durasi_film INTEGER, sutradara_film TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }



    public boolean insertData(String judul_film, String genre_film, String durasi_film, String sutradara_film){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,judul_film);
        contentValues.put(COL_3,genre_film);
        contentValues.put(COL_4,durasi_film);
        contentValues.put(COL_5,sutradara_film);
        long result = db.insert(TABLE_NAME, null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

    public Cursor getId() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select idfilm from " + TABLE_NAME,null);
        return c;
    }

    public boolean updatedata(String id, String judul_film, String genre_film, String durasi_film, String sutradara_film){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,judul_film);
        contentValues.put(COL_3,genre_film);
        contentValues.put(COL_4,durasi_film);
        contentValues.put(COL_5,sutradara_film);
        db.update(TABLE_NAME, contentValues, "idfilm = ?",new String[] { id });
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "idfilm = ?",new String[] {id});
    }
}
