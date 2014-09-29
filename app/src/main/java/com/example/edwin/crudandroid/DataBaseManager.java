package com.example.edwin.crudandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Edwin on 29/09/2014.
 */
public class DataBaseManager {
    //tabla
    public static final String nombre_tabla="Contactos";

    //campos de la tabla
    public static  final String CN_ID="_id";
    public  static final String CN_Nombre="nombre";
    public static  final  String CN_Apellido="apellido";
    public  static  final String CN_Profesion="profesion";
    public  static  final  String CN_Tele="telefono";


public  static final  String CREATE_TABLE =" create table" +nombre_tabla +"("
+CN_ID +" integer primary key autoincrement,"
+CN_Nombre +" text not null,"
+CN_Apellido +" text not null,"
+CN_Profesion + " text not null,"
+CN_Tele +" text null);";


    private  DbHelper helper;
    private  SQLiteDatabase db;
    public DataBaseManager(Context contex) {

         helper= new DbHelper(contex);// creo el contexto
          db=helper.getWritableDatabase();//abrir la bd en mod escritura


    }
public  ContentValues generarContentValues( String nombre,String apellido, String profecion,String telefono){

    ContentValues sql= new ContentValues();
    sql.put(CN_Nombre,nombre);
    sql.put(CN_Apellido,apellido);
    sql.put(CN_Profesion,profecion);
    sql.put(CN_Tele,telefono);
    db.insert(nombre_tabla,null,sql);
    return sql;
}
    public  void insertar( String nombre,String apellido, String profecion,String telefono){
        db.insert(nombre,null,generarContentValues(nombre,apellido,profecion,telefono));
    }

    //otra forma
    public  void  insertar2(String nombre,String apellido, String profecion,String telefono){
        db.execSQL("instrucción normal sql pero con los  parametros ya definidos: tabla, filas etc" +
                "separados con comillas simples ");


    }

    public void eliminar(String nombre){

        db.delete(nombre_tabla, CN_Nombre+"=?",new String[]{nombre});
    }

    public  void eliminarMultiple(String nom1,String nom2){

        db.delete(nombre_tabla,CN_Nombre+"IN (?,?)", new String[]{nom1,nom2});

    }

    public void actualizar(String id, String nombre,String apellido, String profecion,String telefono)
    {


    }


}
