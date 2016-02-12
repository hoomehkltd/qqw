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

import org.kymjs.kjframe.utils.StringUtils;

public class DatabaseOperationResidentialDistrict extends SQLiteOpenHelper{
    public static final int database_version=1;
    public String CreateQuery =
            "CREATE TABLE " + ResidentialDistrict.ResidentialDistrictInfo.TableName+"("+
                    ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictNo+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictKind+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictCount+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.districtArea+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.constructionArea+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.managementCompany+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.managementFee+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.carParkCount+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.developer+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.greenPercentage+" TEXT,"+
                    ResidentialDistrict.ResidentialDistrictInfo.description+" TEXT);"
            ;


    public DatabaseOperationResidentialDistrict(Context context, String name, CursorFactory factory, int version){
        super(context, ResidentialDistrict.ResidentialDistrictInfo.DatabaseName, null, database_version);
        Log.d("Res District ","Database Created");
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

    public static void putInfomation(SQLiteDatabase DB, int ResidentialDistrictNo, String ResidentialDistrictKind, String ResidentialDistrictCount, String districtArea, String constructionArea, String managementCompany, String managementFee, String carParkCount, String developer, String greenPercentage, String description){

        ContentValues cv = new ContentValues();

        cv.put(ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictNo, ResidentialDistrictNo);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictKind, ResidentialDistrictKind);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.ResidentialDistrictCount, ResidentialDistrictCount);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.districtArea, districtArea);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.constructionArea, constructionArea);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.managementCompany, managementCompany);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.managementFee, managementFee);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.carParkCount, carParkCount);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.developer, developer);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.greenPercentage, greenPercentage);
        cv.put(ResidentialDistrict.ResidentialDistrictInfo.description, description);
        DB.insert(ResidentialDistrict.ResidentialDistrictInfo.TableName, null, cv);


        Log.d("Database Operations", "One Row Inserted");

    }

    public static Cursor getCursor(SQLiteDatabase db){

        Cursor cs = db.query(ResidentialDistrict.ResidentialDistrictInfo.TableName,null,null,null,null,null,null);

        return cs;
    }
}
