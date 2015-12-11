package com.example.user.mapapplication;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 9/12/2015.
 */
public class BuildingListOperation {
    public BuildingListOperation() {
    }

    public ArrayList<String> getInitialBuildingNameList(Cursor cs){
        ArrayList<BuildingData> buildingList = new BuildingDataExtract().getInitialBuildingList(cs);
        ArrayList<String> buildingNameListArray = new ArrayList<String>();
        Iterator<BuildingData> buildingDataIterator = buildingList.iterator();
        while (buildingDataIterator.hasNext()){
            buildingNameListArray.add(buildingDataIterator.next().getBuildingName());
        }
        return buildingNameListArray;
    }

    public ArrayList<String> getRegionBuildingNameList(Cursor cs, String region){

        ArrayList<BuildingData> buildingList = new BuildingDataExtract().getRegionList(cs, region);
        ArrayList<String> regionBuildingNameListArray = new ArrayList<String>();
        Iterator<BuildingData> buildingDataIterator = buildingList.iterator();
        while (buildingDataIterator.hasNext()){
            regionBuildingNameListArray.add(buildingDataIterator.next().getBuildingName());
        }


        return regionBuildingNameListArray;
    }
    public ArrayList<String> getDistrictBuildingNameList(Cursor cs, String district){

        ArrayList<BuildingData> buildingList = new BuildingDataExtract().getDistrictList(cs, district);
        ArrayList<String> districtBuildingNameListArray = new ArrayList<String>();
        Iterator<BuildingData> buildingDataIterator = buildingList.iterator();
        while (buildingDataIterator.hasNext()){
            districtBuildingNameListArray.add(buildingDataIterator.next().getBuildingName());
        }


        return districtBuildingNameListArray;
    }
}
