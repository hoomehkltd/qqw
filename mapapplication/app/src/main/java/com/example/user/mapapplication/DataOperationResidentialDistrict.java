package com.example.user.mapapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 22/12/2015.
 */
public class DataOperationResidentialDistrict {
    public void DataOperationResidentialDistrict(){

    }

    public static ResidentialDistrict getResidentialDistrict(int residentialDistrictNo){
        ResidentialDistrict resDis = new ResidentialDistrict();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DatabaseDirectory.getResidentialDistrictDbPath(), null, 0);
        Cursor cursor = DatabaseOperationResidentialDistrict.getCursor(db);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            if (cursor.getString(0).equals(residentialDistrictNo)){
                resDis.setResidentialDistrictKind(cursor.getString(1));
                resDis.setResidentialDistrictCount(Integer.parseInt(cursor.getString(2)));
                resDis.setDistrictArea(cursor.getString(3));
                resDis.setConstructionArea(cursor.getString(4));
                resDis.setManagementCompany(cursor.getString(5));
                resDis.setManagementFee(Float.parseFloat(cursor.getString(6)));
                resDis.setCarParkCount(Integer.parseInt(cursor.getString(7)));
                resDis.setDeveloper(cursor.getString(8));
                resDis.setGreenPercentage(Float.parseFloat(cursor.getString(9)));
                resDis.setDescription(cursor.getString(10));

            }
        }
        return resDis;
    }

    public static void generateRandomResDis(int quantity){
        int i = 0;
        for (i=0; i<quantity; i++){

            SQLiteDatabase db = SQLiteDatabase.openDatabase(DatabaseDirectory.getResidentialDistrictDbPath(), null, 0);
            Cursor cursor = DatabaseOperationResidentialDistrict.getCursor(db);
            DatabaseOperationResidentialDistrict.putInfomation(db, i, null, null, null, null, null, null, null, null, null, null);
        }

    }

}
