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

        map.addMarker(new MarkerOptions().position(klLatLng).title("KL").snippet(Integer.toString(klCount)));
        map.addMarker(new MarkerOptions().position(hkLatLng).title("HK").snippet(Integer.toString(hkCount)));
        map.addMarker(new MarkerOptions().position(ntLatLng).title("NT").snippet(Integer.toString(ntCount)));

    }

    public static void addDistrictMarkersToMap(Cursor cs, GoogleMap map){
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
        map.addMarker(new MarkerOptions().position(cwLatLng).title("CW").snippet(Integer.toString(cwCount)));
        map.addMarker(new MarkerOptions().position(easLatLng).title("EAS").snippet(Integer.toString(easCount)));
        map.addMarker(new MarkerOptions().position(souLatLng).title("SOU").snippet(Integer.toString(souCount)));
        map.addMarker(new MarkerOptions().position(wcLatLng).title("WC").snippet(Integer.toString(wcCount)));
        map.addMarker(new MarkerOptions().position(sspLatLng).title("SSP").snippet(Integer.toString(sspCount)));
        map.addMarker(new MarkerOptions().position(kcLatLng).title("KC").snippet(Integer.toString(kcCount)));
        map.addMarker(new MarkerOptions().position(ktLatLng).title("KT").snippet(Integer.toString(ktCount)));
        map.addMarker(new MarkerOptions().position(wtsLatLng).title("WTS").snippet(Integer.toString(wtsCount)));
        map.addMarker(new MarkerOptions().position(ytmLatLng).title("YTM").snippet(Integer.toString(ytmCount)));
        map.addMarker(new MarkerOptions().position(islLatLng).title("ISL").snippet(Integer.toString(islCount)));
        map.addMarker(new MarkerOptions().position(ktgLatLng).title("KTG").snippet(Integer.toString(ktgCount)));
        map.addMarker(new MarkerOptions().position(norLatLng).title("NOR").snippet(Integer.toString(norCount)));
        map.addMarker(new MarkerOptions().position(skLatLng).title("SK").snippet(Integer.toString(skCount)));
        map.addMarker(new MarkerOptions().position(stLatLng).title("ST").snippet(Integer.toString(stCount)));
        map.addMarker(new MarkerOptions().position(tpLatLng).title("TP").snippet(Integer.toString(tpCount)));
        map.addMarker(new MarkerOptions().position(twLatLng).title("TW").snippet(Integer.toString(twCount)));
        map.addMarker(new MarkerOptions().position(ylLatLng).title("YL").snippet(Integer.toString(ylCount)));
        map.addMarker(new MarkerOptions().position(tmLatLng).title("TM").snippet(Integer.toString(tmCount)));


    }
}
