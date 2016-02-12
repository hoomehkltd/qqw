package com.example.user.mapapplication;

import android.provider.BaseColumns;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 3/12/2015.
 */
public class Apartment {

    private String ApartmentNo;
    private String ApartmentName ;
    private String ApartmentXaxis = "0";
    private String ApartmentYaxis = "0";
    private String ApartmentRegion;
    private String ApartmentDistrict;
    private String ApartmentArea;
    private String DatabaseName;
    private String TableName;
    private LatLng latLng;
    private String FlatPrice;
    private String ResidentialDistrict;



    public void Apartment(){
        ApartmentXaxis = "0";
        ApartmentYaxis = "0";
    }

    public String getResidentialDistrict() {
        return ResidentialDistrict;
    }

    public void setResidentialDistrict(String residentialDistrict) {
        ResidentialDistrict = residentialDistrict;
        Log.d("ResidentialDistrict",ResidentialDistrict);
    }

    public String getFlatPrice() {
        return FlatPrice;
    }

    public void setFlatPrice(String flatPrice) {
        FlatPrice = flatPrice;
        Log.d("FlatPrice",flatPrice);
    }

    public void setApartmentNo(String apartmentNo) {
        ApartmentNo = apartmentNo;
        Log.d("ApartmentNo",apartmentNo);
    }

    public void setApartmentName(String apartmentName) {
        ApartmentName = apartmentName;
        Log.d("apartmentName",apartmentName);
    }

    public void setApartmentXaxis(String apartmentXaxis) {
        ApartmentXaxis = apartmentXaxis;
        double xaxis=Double.valueOf(ApartmentXaxis);
        double yaxis=Double.valueOf(ApartmentYaxis);
        Log.d("ApartmentXaxis figure", ApartmentXaxis);
        latLng = new LatLng(xaxis,yaxis);
        Log.d("setApartmentXaxis","xaxis = "+Double.toString(xaxis));
        Log.d("setApartmentXaxis","yaxis = "+Double.toString(yaxis));
    }

    public void setApartmentYaxis(String apartmentYaxis) {
        ApartmentYaxis = apartmentYaxis;
        double xaxis=Float.valueOf(ApartmentXaxis);
        double yaxis=Float.valueOf(ApartmentYaxis);
        Log.d("ApartmentYaxis figure", ApartmentYaxis);
        latLng = new LatLng(xaxis,yaxis);
        Log.d("setApartmentYaxis","xaxis = "+Double.toString(xaxis));
        Log.d("setApartmentYaxis","yaxis = "+Double.toString(yaxis));
    }

    public void setApartmentRegion(String apartmentRegion) {
        ApartmentRegion = apartmentRegion;
        Log.d("apartmentRegion", apartmentRegion);
    }

    public void setApartmentArea(String apartmentArea) {
        ApartmentArea = apartmentArea;
        Log.d("apartmentArea", apartmentArea);
    }

    public void setDatabaseName(String databaseName) {
        DatabaseName = databaseName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getApartmentNo() {
        return ApartmentNo;
    }

    public String getApartmentName() {
        return ApartmentName;
    }

    public String getApartmentXaxis() {
        return ApartmentXaxis;
    }

    public String getApartmentYaxis() {
        return ApartmentYaxis;
    }

    public String getApartmentRegion() {
        return ApartmentRegion;
    }

    public String getApartmentArea() {
        return ApartmentArea;
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



    public String getApartmentDistrict() {
        return ApartmentDistrict;
    }

    public void setApartmentDistrict(String apartmentDistrict) {
        ApartmentDistrict = apartmentDistrict;
        Log.d("apartmentDistrict", apartmentDistrict);
    }

    public static abstract class ApartmentInfo implements BaseColumns{
        public static final String ApartmentNo = "ApartmentNo";
        public static final String ApartmentName = "ApartmentName";
        public static final String ApartmentXaxis = "ApartmentXaxis";
        public static final String ApartmentYaxis = "ApartmentYaxis";
        public static final String ApartmentRegion = "ApartmentRegion";
        public static final String ApartmentDistrict = "ApartmentDistrict";
        public static final String FlatPrice = "FlatPrice";
        public static final String DatabaseName = "DatabaseName";
        public static final String TableName="reg_in";
        public static final String ResidentialDistrictNo = "ResidentialDistrictNo";

    }
}
