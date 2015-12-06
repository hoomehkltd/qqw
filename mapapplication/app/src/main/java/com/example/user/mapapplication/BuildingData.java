package com.example.user.mapapplication;

import android.provider.BaseColumns;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 3/12/2015.
 */
public class BuildingData {

    private String BuildingNo;
    private String BuildingName ;
    private String BuildingXaxis = "0";
    private String BuildingYaxis = "0";
    private String BuildingRegion;
    private String BuildingArea;
    private String DatabaseName;
    private String TableName;
    private LatLng latLng;
    private String FlatPrice;



    public void BuildingData(){
        BuildingXaxis = "0";
        BuildingYaxis = "0";
    }
    public String getFlatPrice() {
        return FlatPrice;
    }

    public void setFlatPrice(String flatPrice) {
        FlatPrice = flatPrice;
    }

    public void setBuildingNo(String buildingNo) {
        BuildingNo = buildingNo;
    }

    public void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }

    public void setBuildingXaxis(String buildingXaxis) {
        BuildingXaxis = buildingXaxis;
        double xaxis=Double.valueOf(BuildingXaxis);
        double yaxis=Double.valueOf(BuildingYaxis);
        Log.d("BuildingXaxis figure", BuildingXaxis);
        latLng = new LatLng(xaxis,yaxis);
        Log.d("setBuildingXaxis","xaxis = "+Double.toString(xaxis));
        Log.d("setBuildingXaxis","yaxis = "+Double.toString(yaxis));
    }

    public void setBuildingYaxis(String buildingYaxis) {
        BuildingYaxis = buildingYaxis;
        double xaxis=Float.valueOf(BuildingXaxis);
        double yaxis=Float.valueOf(BuildingYaxis);
        Log.d("BuildingYaxis figure", BuildingYaxis);
        latLng = new LatLng(xaxis,yaxis);
        Log.d("setBuildingYaxis","xaxis = "+Double.toString(xaxis));
        Log.d("setBuildingYaxis","yaxis = "+Double.toString(yaxis));
    }

    public void setBuildingRegion(String buildingRegion) {
        BuildingRegion = buildingRegion;
    }

    public void setBuildingArea(String buildingArea) {
        BuildingArea = buildingArea;
    }

    public void setDatabaseName(String databaseName) {
        DatabaseName = databaseName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getBuildingNo() {
        return BuildingNo;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public String getBuildingXaxis() {
        return BuildingXaxis;
    }

    public String getBuildingYaxis() {
        return BuildingYaxis;
    }

    public String getBuildingRegion() {
        return BuildingRegion;
    }

    public String getBuildingArea() {
        return BuildingArea;
    }

    public String getDatabaseName() {
        return DatabaseName;
    }

    public String getTableName() {
        return TableName;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public static abstract class BuildingInfo implements BaseColumns{
        public static final String BuildingNo = "BuildingNo";
        public static final String BuildingName = "BuildingName";
        public static final String BuildingXaxis = "BuildingXaxis";
        public static final String BuildingYaxis = "BuildingYaxis";
        public static final String BuildingRegion = "BuildingRegion";
        public static final String BuildingDistrict = "BuildingDistrict";
        public static final String FlatPrice = "FlatPrice";
        public static final String DatabaseName = "DatabaseName";
        public static final String TableName="reg_in";

    }
}
