package com.example.lenovo.apprestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(codigo integer primary key autoincrement, usuario text, contraceña text)");
        db.execSQL("insert into usuarios values('admin', 'admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table usuario(codigo integer primary key autoincrement, usuario text, contraceña text)");
        db.execSQL("insert into usuarios values('admin', 'admin')");
    }
}
