package com.example.edwin.crudandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Edwin on 29/09/2014.
 */
public class DbHelper extends SQLiteOpenHelper{
   private  static final String DB_Name="contacto.sqlite";//name base de datos
    private static  final int DB_SCHEME_VERSION=1;//control de versiones de la bd


    public DbHelper(Context contex) {
        super(contex, DB_Name, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
