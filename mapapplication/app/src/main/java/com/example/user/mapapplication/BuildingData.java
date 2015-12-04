package com.example.user.mapapplication;

import android.provider.BaseColumns;

/**
 * Created by user on 3/12/2015.
 */
public class BuildingData {

    public void BuildingData(){

    }

    public static abstract class BuildingInfo implements BaseColumns{
        public static final String BuildingNo = "BuildingNo";
        public static final String BuildingName = "BuildingName";
        public static final String BuildingXaxis = "BuildingXaxis";
        public static final String BuildingYaxis = "BuildingYaxis";
        public static final String BuildingRegion = "BuildingRegion";
        public static final String BuildingArea = "BuildingArea";
        public static final String DatabaseName = "DatabaseName";
        public static final String TableName="reg_in";

    }
}
