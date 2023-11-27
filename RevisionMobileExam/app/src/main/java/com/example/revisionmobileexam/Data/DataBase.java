package com.example.revisionmobileexam.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DataBase extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "Jeu.db";
    private static final int DATABASE_VERSION = 2;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, TableString.class);

        }catch (Exception e){
            Log.i("Error DATABASE perso","Error creation db : "+e.getMessage().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, TableString.class,true);
            onCreate(database,connectionSource);
        }catch (Exception e){
            Log.i("Error DATABASE perso","Error creation db : "+e.getMessage().toString());
        }
    }

    public void insert(TableString st)  {
        try {
            Dao<TableString,Integer> dao = getDao(TableString.class);
            dao.create(st);
        }catch (Exception e){
            Log.i("Error DATABASE perso","Error insertion joueur table : "+e.getMessage().toString());
        }
    }

    public TableString  getByID(int id)  {
        TableString ret;
        try {
            Dao<TableString,Integer> dao = getDao(TableString.class);
            ret =dao.queryForId(id);
            return ret;
        }catch (Exception e){
            Log.i("Error DATABASE perso","Error insertion joueur table : "+e.getMessage().toString());
            return  null;
        }

    }

    public void  deleteByID(int id)  {
        TableString ret;
        try {
            Dao<TableString, Integer> dao = getDao( TableString.class );
            dao.deleteById(id);
        }catch (Exception e){
            Log.i("Error DATABASE perso","Error insertion joueur table : "+e.getMessage().toString());
        }

    }
}
