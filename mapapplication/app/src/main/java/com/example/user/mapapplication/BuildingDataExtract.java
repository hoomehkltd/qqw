package com.example.user.mapapplication;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by user on 4/12/2015.
 */
public class BuildingDataExtract {

    public void BuildingDataExtract(){

    };

    public ArrayList<BuildingData> getAllBuildingCoord(Cursor cs){

        ArrayList<BuildingData> BuildingList = new ArrayList<BuildingData>();
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

    public ArrayList<BuildingData> getInitialBuildingList(Cursor cs){
        ArrayList<BuildingData> buildingList = new ArrayList<BuildingData>();
        buildingList = getAllBuildingCoord(cs);
        return buildingList;
    };

    public ArrayList<BuildingData> getRegionList(Cursor cs, String region){
        ArrayList<BuildingData> buildingList = new ArrayList<BuildingData>();
        cs.moveToFirst();
        do {
            if (region.equals(cs.getString(2))){
                BuildingData building = new BuildingData();
                building.setBuildingNo(cs.getString(0));
                building.setBuildingName(cs.getString(1));
                building.setBuildingXaxis(cs.getString(5));
                building.setBuildingYaxis(cs.getString(6));
                building.setFlatPrice(cs.getString(4));
                buildingList.add(building);
            }
            Log.d("regionofdatabase", cs.getString(2));
            }
        while(cs.moveToNext());

        return buildingList;
    }

    public ArrayList<BuildingData> getDistrictList(Cursor cs, String district){
        ArrayList<BuildingData> buildingList = new ArrayList<BuildingData>();
        cs.moveToFirst();
        do {
            if (district.equals(cs.getString(3))){
                BuildingData building = new BuildingData();
                building.setBuildingNo(cs.getString(0));
                building.setBuildingName(cs.getString(1));
                building.setBuildingXaxis(cs.getString(5));
                building.setBuildingYaxis(cs.getString(6));
                building.setFlatPrice(cs.getString(4));
                buildingList.add(building);
                Log.d("districtofdatabase", cs.getString(3));
            }

        }
        while(cs.moveToNext());

        return buildingList;
    }
}
