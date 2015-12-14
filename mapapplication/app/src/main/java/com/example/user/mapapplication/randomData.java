package com.example.user.mapapplication;

import android.util.Log;

/**
 * Created by user on 5/12/2015.
 */
public class randomData {
    public String getRandomRegion(){
            String[] randomRegion = new String[3];
            int i = (int) Math.floor(randomRegion.length * Math.random());
            String region;
            randomRegion[0] = "KL";
            randomRegion[1] = "HK";
            randomRegion[2] = "NT";
            region = randomRegion[i];
            return region;

    }
    public String getRandomDistrict(){
        String[] randomDistrict = new String[18];
        int i = (int) Math.floor(randomDistrict.length * Math.random());
        String district;
        randomDistrict[0] = "CW";
        randomDistrict[1] = "EAS";
        randomDistrict[2] = "SOU";
        randomDistrict[3] = "WC";
        randomDistrict[4] = "SSP";
        randomDistrict[5] = "KC";
        randomDistrict[6] = "KT";
        randomDistrict[7] = "WTS";
        randomDistrict[8] = "YTM";
        randomDistrict[9] = "ISL";
        randomDistrict[10] = "KTG";
        randomDistrict[11] = "NOR";
        randomDistrict[12] = "SK";
        randomDistrict[13] = "ST";
        randomDistrict[14] = "TP";
        randomDistrict[15] = "TW";
        randomDistrict[16] = "YL";
        randomDistrict[17] = "TM";

        district = randomDistrict[i];
        return district;

    }
    public int getRandomFlatPrice(){
        int RandomFlatPrice ;
        int maxFlatPrice = 6000000;
        RandomFlatPrice = (int) Math.floor(maxFlatPrice * Math.random());

        return RandomFlatPrice;
    }

    public double getRandomLat(){
        Double randomLat ;
        double leftMost = 22.257788;
        double rightMost = 22.625020;
        randomLat = leftMost+((rightMost-leftMost) * Math.random());
        Log.d("randomLat",randomLat.toString());
        return randomLat;
    }

    public double getRandomLng(){
        Double randomLng ;
        double upMost = 114.095425;
        double downMost = 114.273511;
        randomLng = upMost+((downMost-upMost) * Math.random());
        Log.d("randomLng",randomLng.toString());
        return randomLng;
    }

    public static int getRandomPhoneNo(){
        int randomPhoneNo ;
        int upMost = 99999999;
        int downMost = 77777777;
        randomPhoneNo = downMost+(int)Math.round(((upMost - downMost) * Math.random()));
        Log.d("randomPhoneNo",Integer.toString(randomPhoneNo));
        return randomPhoneNo;

    }
}
