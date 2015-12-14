package com.example.user.mapapplication;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.KJDB;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.kymjs.kjframe.SupportActivity;
import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.utils.KJConfig;
import java.util.ArrayList;
import org.kymjs.kjframe.ui.KJActivityStack;
/**
 * Created by user on 11/12/2015.
 */
public class BuildingActivity extends SupportActivity {

    @BindView(id=R.id.text_pricepermonth)
            private TextView pricepermonth;

    @BindView(id=R.id.text_apartmentname)
            private TextView apartmentname;

    private SQLiteDatabase db;
    public Cursor cs;
    public int ApartmentNo;
    public String ApartmentName;

    @Override
    public void setRootView(){
        setContentView(R.layout.activity_building);
    }
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        db = SQLiteDatabase.openDatabase(intent.getStringExtra("dbpath"), null, 0);
        cs = BuildingDatabaseOperation.getInformation(db);
        Log.d("ApartmentNo", intent.getStringExtra("BuildingNo"));
        ApartmentNo = Integer.parseInt(intent.getStringExtra("BuildingNo"));
        BuildingData BuildingData = new BuildingData();
//        getBuildingData();
        cs.moveToFirst();
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(ApartmentNo))){
                BuildingData.setFlatPrice(cs.getString(4));

                BuildingData.setBuildingName(cs.getString(1));
                Log.d("BuildingDataSet", "Building Set Successfully");
            }
        }
        ((Activity) this).setContentView(R.layout.activity_building);
        String apartmentName = BuildingData.getBuildingName();
        Log.d("apartmentName", apartmentName);
        String pricePerMonth = BuildingData.getFlatPrice();
        Log.d("pricePerMonth", pricePerMonth);
        apartmentname.setText(apartmentName);
        Log.d("apartmentnameset", apartmentname.getText().toString());
        pricepermonth.setText(pricePerMonth);

    }

//    public void getBuildingData(){
//        cs.moveToFirst();
//        while (cs.moveToNext()){
//            if (cs.getString(0).equals(Integer.toString(ApartmentNo))){
//                BuildingData.setFlatPrice(cs.getString(4));
//
//                BuildingData.setBuildingName(cs.getString(1));
//                Log.d("BuildingDataSet", "Building Set Successfully");
//            }
//        }
//
//
//
//    }


    @BindView(id=R.id.btn_addtoshoppingcartbtn, click = true)
    private Button addToShoppingCartBtn;



    @Override
    public void initWidget() {
        super.initWidget();
    }

    @Override
    public void widgetClick(View view){
        super.widgetClick(view);
        switch (view.getId()){
            case R.id.btn_addtoshoppingcartbtn:
                userDataOperation userData = new userDataOperation();
//                userData.addItemtoShoppingCartInput(MapsActivity.getUser(), MapsActivity.getMyLastBuildingClick(), MapsActivity.getUserDb());

        }

    }
}

