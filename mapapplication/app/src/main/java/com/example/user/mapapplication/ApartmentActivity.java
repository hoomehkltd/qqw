package com.example.user.mapapplication;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.KJDB;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;

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
public class ApartmentActivity extends Activity{
    public static String apartmentNo;
    public static String apartmentDbPath;
    public static int userId;
    public static String userDbPath;
    public static String pricePerMonth;
    public TextView apartmentNameView;
    public TextView pricePerMonthView;
    public Button addToShoppingCartView;
    public FrameLayout residentialDistrict;
    public static Apartment apartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        apartment = new Apartment();
        retriveData(intent);
        apartment = setapartment(apartment);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_apartment);
        setVariableView();
        setVariableInViews(apartment);
        setOnClick();


    }


    public void retriveData(Intent intent) {

        apartmentNo = intent.getStringExtra("apartmentNo");
        apartmentDbPath = intent.getStringExtra("apartmentDbPath");
        userId = intent.getIntExtra("userId", 0);
        userDbPath = intent.getStringExtra("userDbPath");

    }

    public void setVariableView(){
        apartmentNameView = (TextView) findViewById(R.id.text_apartmentname);
        pricePerMonthView = (TextView) findViewById(R.id.text_pricepermonth);
        addToShoppingCartView = (Button) findViewById(R.id.btn_addtoshoppingcartbtn);
        residentialDistrict = (FrameLayout) findViewById(R.id.residentialdistrictframe);


    }

    public void setVariableInViews(Apartment apartment){
        apartmentNameView.setText(apartment.getApartmentName());
        pricePerMonthView.setText(apartment.getFlatPrice());

    }

    public void setOnClick(){
        addToShoppingCartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToShoppingCartView.setText("Added");
                DataOperationUser userDataOperation = new DataOperationUser();
                userDataOperation.addItemtoShoppingCart(userId, apartmentNo);

            }
        });

        residentialDistrict.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(ApartmentActivity.this, ResidentialDistrictActivity.class);
                intent.putExtra("resDistrictNo", apartment.getResidentialDistrict());
                intent.putExtra("apartmentDbPath", apartmentDbPath);
                startActivity(intent);
                return false;
            }
        });

    }

    public Apartment setapartment(Apartment apartment){
        Cursor cs = DatabaseDirectory.getApartmentDbCursor();
        cs.moveToFirst();
        while (cs.moveToNext()) {
            if (cs.getString(0).equals(apartmentNo)) {
                apartment.setApartmentNo(cs.getString(0));
                apartment.setApartmentName(cs.getString(1));
                apartment.setApartmentRegion(cs.getString(2));
                apartment.setApartmentDistrict(cs.getString(3));
                apartment.setFlatPrice(cs.getString(4));
                apartment.setApartmentXaxis(cs.getString(5));
                apartment.setApartmentYaxis(cs.getString(6));
                apartment.setResidentialDistrict(cs.getString(7));
                Log.d("apartmentSet", "Apartment Set Successfully");
            }
        }

        return apartment;
    }
}

