package com.example.user.mapapplication;

/**
 * Created by user on 3/12/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class BuildingDatabaseOperation extends SQLiteOpenHelper{
    public static final int database_version=1;
    public String CreateQuery =
            "CREATE TABLE " + BuildingData.BuildingInfo.TableName+"("+
                    BuildingData.BuildingInfo.BuildingName+" TEXT,"+
                    BuildingData.BuildingInfo.BuildingRegion+" TEXT,"+
                    BuildingData.BuildingInfo.BuildingArea+" TEXT,"+
                    BuildingData.BuildingInfo.BuildingXaxis+" TEXT,"+
                    BuildingData.BuildingInfo.BuildingYaxis+" TEXT);"
            ;
    public BuildingDatabaseOperation(Context context, String name, CursorFactory factory, int version){
        super(context, BuildingData.BuildingInfo.DatabaseName, null, database_version);
        Log.d("Database Operations","Database Created");
    }
    @Override
    public void onCreate (SQLiteDatabase sdb){

        sdb.execSQL(CreateQuery);
        Log.d("Table Operations", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){

    }

    public SQLiteDatabase opendb(){
        SQLiteDatabase SQ = this.getWritableDatabase();
        return SQ;
    }

    public synchronized void closedb(SQLiteDatabase sdb){
       this.close();
    }

    public void putInfomation(SQLiteDatabase DB, int buildingNo, String name, String region, String area, int xaxis, int yaxis){

        ContentValues cv = new ContentValues();

        cv.put(BuildingData.BuildingInfo.BuildingNo, buildingNo);
        cv.put(BuildingData.BuildingInfo.BuildingName, name);
        cv.put(BuildingData.BuildingInfo.BuildingArea, area);
        cv.put(BuildingData.BuildingInfo.BuildingRegion, region);
        cv.put(BuildingData.BuildingInfo.BuildingXaxis, xaxis);
        cv.put(BuildingData.BuildingInfo.BuildingYaxis, yaxis);
        DB.insert(BuildingData.BuildingInfo.TableName, null, cv);

        Log.d("Database Operations", "One Row Inserted");
    }

    public void getAllInformation(SQLiteDatabase db){

        

    }
}
