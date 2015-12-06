package com.example.user.mapapplication;

import android.database.Cursor;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by user on 6/12/2015.
 */
public class addMarkersToMap {
    public static LatLng hkLatLng = new LatLng(22.26686,114.17885);
    public static LatLng ntLatLng = new LatLng(22.41667,114.08333);
    public static LatLng klLatLng = new LatLng(22.31667,114.18333);
    public static LatLng cwLatLng = new LatLng(22.28666,114.15497);
    public static LatLng easLatLng = new LatLng(22.28411,114.22414);
    public static LatLng souLatLng = new LatLng(22.24725,114.15884);
    public static LatLng wcLatLng = new LatLng(22.27968,114.17168);
    public static LatLng sspLatLng = new LatLng(22.33074,114.1622);
    public static LatLng kcLatLng = new LatLng(22.3282,114.19155);
    public static LatLng ktLatLng = new LatLng(22.31326,114.22581);
    public static LatLng wtsLatLng = new LatLng(22.33353,114.19686);
    public static LatLng ytmLatLng = new LatLng(22.32138,114.1726);
    public static LatLng islLatLng = new LatLng(22.26114,113.94608);
    public static LatLng ktgLatLng = new LatLng(22.35488,114.08401);
    public static LatLng norLatLng = new LatLng(22.35488,114.08401);
    public static LatLng skLatLng = new LatLng(22.38143,114.27052);
    public static LatLng stLatLng = new LatLng(22.38715,114.19534);
    public static LatLng tpLatLng = new LatLng(22.45085,114.16422);
    public static LatLng twLatLng = new LatLng(22.36281,114.12907);
    public static LatLng ylLatLng = new LatLng(22.44559,114.02218);
    public static LatLng tmLatLng = new LatLng(22.39211,113.97011);


    public static void addInitialMarkersToMap(Cursor cs, GoogleMap map) {
        cs.moveToFirst();
        int klCount = 0;
        int hkCount = 0;
        int ntCount = 0;

        do {
            Log.d("RegionIs",cs.getString(2));
            if (cs.getString(2).equals("KL")) {
                klCount += 1;
            }
            else if (cs.getString(2).equals("HK")){
                hkCount += 1;
            }
            else if (cs.getString(2).equals("NT")){
                ntCount +=1;
            }
        }
        while(cs.moveToNext());

        map.addMarker(new MarkerOptions().position(klLatLng).title(Integer.toString(klCount)));
        map.addMarker(new MarkerOptions().position(hkLatLng).title(Integer.toString(hkCount)));
        map.addMarker(new MarkerOptions().position(ntLatLng).title(Integer.toString(ntCount)));
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(22.447088, 114.137932)));
        map.animateCamera(CameraUpdateFactory.zoomTo(MapsActivity.regionZoomLevel), 2000, null);
    }

    public static void addDistrictMarkersToMap(Cursor cs, GoogleMap map, LatLng latLng){
        int cwCount = 0;
        int easCount = 0;
        int souCount = 0;
        int wcCount = 0;
        int sspCount = 0;
        int kcCount = 0;
        int ktCount = 0;
        int norCount = 0;
        int wtsCount = 0;
        int ytmCount = 0;
        int islCount = 0;
        int ktgCount = 0;
        int skCount = 0;
        int stCount = 0;
        int tpCount = 0;
        int twCount = 0;
        int ylCount = 0;
        int tmCount = 0;

        map.clear();
        latLng = latLng;
        cs.moveToFirst();
        Log.d("District",cs.getString(3));

        do {

            if (cs.getString(3).equals("CW")) {
                cwCount += 1;
            }
            else if (cs.getString(3).equals("EAS")){
                easCount += 1;
            }
            else if (cs.getString(3).equals("SOU")){
                souCount +=1;
            }
            else if (cs.getString(3).equals("WC")){
                wcCount +=1;
            }
            else if (cs.getString(3).equals("SSP")){
                sspCount +=1;
            }
            else if (cs.getString(3).equals("KC")){
                kcCount +=1;
            }
            else if (cs.getString(3).equals("KT")){
                ktCount +=1;
            }
            else if (cs.getString(3).equals("WTS")){
                wtsCount +=1;
            }
            else if (cs.getString(2).equals("YTM")){
                ytmCount +=1;
            }
            else if (cs.getString(3).equals("ISL")){
                islCount +=1;
            }
            else if (cs.getString(3).equals("KT")){
                ktgCount +=1;
            }
            else if (cs.getString(3).equals("NOR")){
                norCount +=1;
            }
            else if (cs.getString(3).equals("SK")){
                skCount +=1;
            }
            else if (cs.getString(3).equals("ST")){
                stCount +=1;
            }
            else if (cs.getString(3).equals("TP")){
                tpCount +=1;
            }
            else if (cs.getString(3).equals("TW")){
                twCount +=1;
            }
            else if (cs.getString(3).equals("YL")){
                ylCount +=1;
            }
            else if (cs.getString(3).equals("TM")){
                tmCount +=1;
            }

        }
        while(cs.moveToNext());
        map.addMarker(new MarkerOptions().position(cwLatLng).title(Integer.toString(cwCount)));
        map.addMarker(new MarkerOptions().position(easLatLng).title(Integer.toString(easCount)));
        map.addMarker(new MarkerOptions().position(souLatLng).title(Integer.toString(souCount)));
        map.addMarker(new MarkerOptions().position(wcLatLng).title(Integer.toString(wcCount)));
        map.addMarker(new MarkerOptions().position(sspLatLng).title(Integer.toString(sspCount)));
        map.addMarker(new MarkerOptions().position(kcLatLng).title(Integer.toString(kcCount)));
        map.addMarker(new MarkerOptions().position(ktLatLng).title(Integer.toString(ktCount)));
        map.addMarker(new MarkerOptions().position(wtsLatLng).title(Integer.toString(wtsCount)));
        map.addMarker(new MarkerOptions().position(ytmLatLng).title(Integer.toString(ytmCount)));
        map.addMarker(new MarkerOptions().position(islLatLng).title(Integer.toString(islCount)));
        map.addMarker(new MarkerOptions().position(ktgLatLng).title(Integer.toString(ktgCount)));
        map.addMarker(new MarkerOptions().position(norLatLng).title(Integer.toString(norCount)));
        map.addMarker(new MarkerOptions().position(skLatLng).title(Integer.toString(skCount)));
        map.addMarker(new MarkerOptions().position(stLatLng).title(Integer.toString(stCount)));
        map.addMarker(new MarkerOptions().position(tpLatLng).title(Integer.toString(tpCount)));
        map.addMarker(new MarkerOptions().position(twLatLng).title(Integer.toString(twCount)));
        map.addMarker(new MarkerOptions().position(ylLatLng).title(Integer.toString(ylCount)));
        map.addMarker(new MarkerOptions().position(tmLatLng).title(Integer.toString(tmCount)));

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
    }
}
