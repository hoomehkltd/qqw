package com.example.user.mapapplication;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by user on 4/12/2015.
 */
public class BuildingDataExtract {

    public void BuildingDataExtract(){

    };

    public ArrayList<Object> getAllBuildingCoord(Cursor cs){

        ArrayList<Object> BuildingList = new ArrayList<Object>();
        cs.moveToFirst();
        do {
            BuildingData building = new BuildingData();
            building.setBuildingNo(cs.getString(0));
            building.setBuildingName(cs.getString(1));
            building.setBuildingXaxis(cs.getString(5));
            building.setBuildingYaxis(cs.getString(6));
            building.setFlatPrice(cs.getString(4));
            BuildingList.add(building);
        ;}
        while(cs.moveToNext());

        return BuildingList;
    };

    public void getBuilding(){

    };
}
