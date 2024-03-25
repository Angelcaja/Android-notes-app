package com.example.evaluableuf1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {
    public DataBaseSQL(@Nullable Context context) {
        super(context, "BBDDnotas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE notas (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nota TEXT)");
        db.execSQL("INSERT INTO notas VALUES (null, 'producto de ejemplo')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notas");
        this.onCreate(db);
    }

    public ArrayList<String> getProductos(){

        ArrayList<String> lista = new ArrayList<String>();

        //Abro la BBDD en modo lectura
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = null;
        res = db.rawQuery("SELECT * FROM notas", null);
        res.moveToLast();

        if (res.getCount() > 0){
            res.moveToFirst();
            while (!res.isAfterLast()){

                lista.add(res.getString(0) + ".-" + res.getString(1));
                res.moveToNext();
            }
        }

        return lista;
    }


    public boolean insertarNota(String nota){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO notas VALUES (null, '" + nota + " ')");
        return true;
    }

    public boolean borrarNota(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas WHERE id = " + id);
        return true;
    }

    public boolean borrarTodasNotas (){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas");

        return true;
    }
}
