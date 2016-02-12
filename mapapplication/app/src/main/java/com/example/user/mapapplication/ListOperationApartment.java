package com.example.user.mapapplication;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 9/12/2015.
 */
public class ListOperationApartment {
    public ListOperationApartment() {
    }

    public ArrayList<String> getInitialApartmentNameList(Cursor cs){
        ArrayList<Apartment> apartmentList = new DataOperationApartment().getInitialApartmentList(cs);
        ArrayList<String> apartmentNameListArray = new ArrayList<String>();
        Iterator<Apartment> apartmentIterator = apartmentList.iterator();
        while (apartmentIterator.hasNext()){
            apartmentNameListArray.add(apartmentIterator.next().getApartmentName());
        }
        return apartmentNameListArray;
    }

    public ArrayList<String> getRegionApartmentNameList(Cursor cs, String region){

        ArrayList<Apartment> apartmentList = new DataOperationApartment().getRegionList(cs, region);
        ArrayList<String> regionApartmentNameListArray = new ArrayList<String>();
        Iterator<Apartment> apartmentIterator = apartmentList.iterator();
        while (apartmentIterator.hasNext()){
            regionApartmentNameListArray.add(apartmentIterator.next().getApartmentName());
        }


        return regionApartmentNameListArray;
    }
    public ArrayList<String> getDistrictApartmentNameList(Cursor cs, String district){

        ArrayList<Apartment> apartmentList = new DataOperationApartment().getDistrictList(cs, district);
        ArrayList<String> districtApartmentNameListArray = new ArrayList<String>();
        Iterator<Apartment> apartmentIterator = apartmentList.iterator();
        while (apartmentIterator.hasNext()){
            districtApartmentNameListArray.add(apartmentIterator.next().getApartmentName());
        }


        return districtApartmentNameListArray;
    }
}
