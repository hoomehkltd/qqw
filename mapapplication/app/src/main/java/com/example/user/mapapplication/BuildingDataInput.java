package com.example.user.mapapplication;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by user on 3/12/2015.
 */
public class BuildingDataInput {
    public BuildingDataInput(){

    }

    public void BuildingData(BuildingDatabaseOperation dh, SQLiteDatabase db){

        dh.putInfomation(db,1,"buildinga","kl","tw",-24,151);
        dh.putInfomation(db,2,"buildingb","kl","tw",-23,161);
        dh.putInfomation(db,3,"buildingc","kl","tw",-22,141);
        dh.putInfomation(db,4, "buildingd","kl","tw",-24,131);
        Log.d("Building Data", "Building Data is inputed");

    }

}
