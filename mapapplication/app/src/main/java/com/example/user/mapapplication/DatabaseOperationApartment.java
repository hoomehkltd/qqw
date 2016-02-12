package com.example.user.mapapplication;

/**
 * Created by user on 3/12/2015.
 */

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class DatabaseOperationApartment extends SQLiteOpenHelper{
    public static final int database_version=1;
    public String CreateQuery =
            "CREATE TABLE " + Apartment.ApartmentInfo.TableName+"("+
                    Apartment.ApartmentInfo.ApartmentNo+" TEXT,"+
                    Apartment.ApartmentInfo.ApartmentName+" TEXT,"+
                    Apartment.ApartmentInfo.ApartmentRegion+" TEXT,"+
                    Apartment.ApartmentInfo.ApartmentDistrict+" TEXT,"+
                    Apartment.ApartmentInfo.FlatPrice+" TEXT,"+
                    Apartment.ApartmentInfo.ApartmentXaxis+" TEXT,"+
                    Apartment.ApartmentInfo.ApartmentYaxis+" TEXT,"+
                    Apartment.ApartmentInfo.ResidentialDistrictNo+" TEXT);"
            ;
    public DatabaseOperationApartment(Context context, String name, CursorFactory factory, int version){
        super(context, Apartment.ApartmentInfo.DatabaseName, null, database_version);
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

    public void putInfomation(SQLiteDatabase DB, int apartmentNo, String name, String region, String district, int flatPrice, double xaxis, double yaxis, String residentialDistrictNo){

        ContentValues cv = new ContentValues();

        cv.put(Apartment.ApartmentInfo.ApartmentNo, apartmentNo);
        cv.put(Apartment.ApartmentInfo.ApartmentName, name);
        cv.put(Apartment.ApartmentInfo.ApartmentRegion, region);
        cv.put(Apartment.ApartmentInfo.ApartmentDistrict, district);
        cv.put(Apartment.ApartmentInfo.FlatPrice, flatPrice);
        cv.put(Apartment.ApartmentInfo.ApartmentXaxis, xaxis);
        cv.put(Apartment.ApartmentInfo.ApartmentYaxis, yaxis);
        cv.put(Apartment.ApartmentInfo.ResidentialDistrictNo, residentialDistrictNo);
        DB.insert(Apartment.ApartmentInfo.TableName, null, cv);

        Log.d("Database Operations", "One Row Inserted");
        Log.d(cv.getAsString(Apartment.ApartmentInfo.ApartmentName),cv.getAsString(Apartment.ApartmentInfo.ApartmentName));
    }

    public static Cursor getCursor(SQLiteDatabase db){

        Cursor cs = db.query(Apartment.ApartmentInfo.TableName,null,null,null,null,null,null);

    return cs;
    }
}
