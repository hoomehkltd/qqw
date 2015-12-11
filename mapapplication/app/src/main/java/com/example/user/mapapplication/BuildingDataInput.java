package com.example.user.mapapplication;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by user on 3/12/2015.
 */


public class BuildingDataInput {
    public BuildingDataInput() {

    }

    public void BuildingData(BuildingDatabaseOperation dh, SQLiteDatabase db) {


        for (int j = 1; j < 20; j++) {
            String randomRegion = new randomData().getRandomRegion();
            String randomDistrict = new randomData().getRandomDistrict();
            int randomPrice = new randomData().getRandomFlatPrice();
            double randomLat = new randomData().getRandomLat();
            double randomLng = new randomData().getRandomLng();
            dh.putInfomation(db, j, "building" + j, randomRegion, randomDistrict, randomPrice, randomLat, randomLng);

            Log.d("Building Data", "Building Data is inputed");
        }
    }


}
