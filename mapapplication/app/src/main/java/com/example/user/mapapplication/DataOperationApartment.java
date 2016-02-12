package com.example.user.mapapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by user on 4/12/2015.
 */
public class DataOperationApartment {

    public void DataOperationApartment(){

    };

    public void randomApartment(DatabaseOperationApartment dh, SQLiteDatabase db) {


        for (int j = 1; j < 20; j++) {
            String randomRegion = new randomData().getRandomRegion();
            String randomDistrict = new randomData().getRandomDistrict();
            String residentialDistrictNo = Integer.toString(j);
            int randomPrice = new randomData().getRandomFlatPrice();
            double randomLat = new randomData().getRandomLat();
            double randomLng = new randomData().getRandomLng();
            dh.putInfomation(db, j, "apartment" + j, randomRegion, randomDistrict, randomPrice, randomLat, randomLng, residentialDistrictNo);

            Log.d("Apartment Data", "Apartment Data is inputed");
        }
    }

    public ArrayList<Apartment> getAllApartmentCoord(Cursor cs){

        ArrayList<Apartment> ApartmentList = new ArrayList<Apartment>();
        cs.moveToFirst();
        do {
            Apartment apartment = new Apartment();
            apartment.setApartmentNo(cs.getString(0));
            apartment.setApartmentName(cs.getString(1));
            apartment.setApartmentXaxis(cs.getString(5));
            apartment.setApartmentYaxis(cs.getString(6));
            apartment.setFlatPrice(cs.getString(4));
            ApartmentList.add(apartment);
        ;}
        while(cs.moveToNext());

        return ApartmentList;
    };

    public ArrayList<Apartment> getInitialApartmentList(Cursor cs){
        ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
        apartmentList = getAllApartmentCoord(cs);
        return apartmentList;
    };

    public ArrayList<Apartment> getRegionList(Cursor cs, String region){
        ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
        cs.moveToFirst();
        do {
            if (region.equals(cs.getString(2))){
                Apartment apartment = new Apartment();
                apartment.setApartmentNo(cs.getString(0));
                apartment.setApartmentName(cs.getString(1));
                apartment.setApartmentXaxis(cs.getString(5));
                apartment.setApartmentYaxis(cs.getString(6));
                apartment.setFlatPrice(cs.getString(4));
                apartmentList.add(apartment);
            }
            Log.d("regionofdatabase", cs.getString(2));
            }
        while(cs.moveToNext());

        return apartmentList;
    }


    public ArrayList<Apartment> getDistrictList(Cursor cs, String district){
        ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
        cs.moveToFirst();
        do {
            if (district.equals(cs.getString(3))){
                Apartment apartment = new Apartment();
                apartment.setApartmentNo(cs.getString(0));
                apartment.setApartmentName(cs.getString(1));
                apartment.setApartmentXaxis(cs.getString(5));
                apartment.setApartmentYaxis(cs.getString(6));
                apartment.setFlatPrice(cs.getString(4));
                apartmentList.add(apartment);
                Log.d("districtofdatabase", cs.getString(3));
            }

        }
        while(cs.moveToNext());

        return apartmentList;
    }

    public static Apartment getApartmentById(String id){

        Apartment apartment = new Apartment();
        Cursor cs = new DatabaseDirectory().getApartmentDbCursor();
        Log.d("CursorColume0", cs.getColumnName(0));
        Log.d("CursorColume1", cs.getColumnName(1));
        cs.moveToFirst();
        Log.d("getApartmentById",id);
        do {
            Log.d("ColumnId",cs.getString(0));
            if (cs.getString(0).equals(id)){
                Log.d("ReachDatabase,column=", id);
                apartment.setApartmentNo(cs.getString(0));
                apartment.setApartmentName(cs.getString(1));
                apartment.setApartmentRegion(cs.getString(2));
                apartment.setResidentialDistrict(cs.getString(3));
                apartment.setFlatPrice(cs.getString(4));
                apartment.setApartmentXaxis(cs.getString(5));
                apartment.setApartmentYaxis(cs.getString(6));
                apartment.setResidentialDistrict(cs.getString(7));
            }
        }
        while (cs.moveToNext());
        return apartment;
    }

}
