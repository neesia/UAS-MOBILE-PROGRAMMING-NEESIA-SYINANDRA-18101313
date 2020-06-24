package com.neesia.uasmobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sql1 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "film.db";
    private static final int DATABASE_VERSION = 1 ;
    public sql1 (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table film (id integer primary key autoincrement, " +
                "                judul_film text null, " +
                "                judul_versiindonesia text null, " +
                "                tahun_tayang text null, " +
                "                peringkat text null);";
        Log.d("Data","OnCreate+" + sql1);
        db.execSQL(sql1);
        sql1 = "INSERT INTO film(id, judul_film, judul_versiindonesia, tahun_tayang, peringkat)" +
                "              VALUES(1,'Harry Potter and the Philosopers Stone','Harry Potter dan Batu Bertuah','2001','8/10');";
        db.execSQL(sql1);
        sql1 = "INSERT INTO film(id, judul_film, judul_versiindonesia, tahun_tayang, peringkat)" +
                "              VALUES(2,'Harry Potter and the Chamber of Secrets','Harry Potter dan Kamar Rahasia','2002','8/10');";
        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
