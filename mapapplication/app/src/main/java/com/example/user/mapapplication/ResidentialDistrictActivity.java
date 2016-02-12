package com.example.user.mapapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ResidentialDistrictActivity extends AppCompatActivity {

    int resDistrictNo;
    ResidentialDistrict residentialDistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residential_district);
        resDistrictNo = Integer.parseInt(getIntent().getStringExtra("resDistrictNo"));
        Log.d("resDis", Integer.toString(resDistrictNo));
        residentialDistrict = DataOperationResidentialDistrict.getResidentialDistrict(resDistrictNo);
    }


}
