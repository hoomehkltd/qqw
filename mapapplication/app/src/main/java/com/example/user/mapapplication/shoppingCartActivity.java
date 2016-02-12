package com.example.user.mapapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    ListView listShoppingCart ;
    public static int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        userId = getIntent().getIntExtra("userId", 0);
        setContentView(R.layout.activity_shoppingcart);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.shoppingcartmain);
        rl.setBackgroundColor(Color.WHITE);
        setShoppingCartListView();

    }

    @Override
    protected void onResume(){
        super.onResume();
        setShoppingCartListView();
    }

    public void setShoppingCartListView(){
        listShoppingCart = (ListView)findViewById(R.id.list_shoppingcart);
        ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
        apartmentList = getApartmentList();
        Log.d("Hiyo","");
        for (int i=0; i<apartmentList.size(); i++){
            String no = apartmentList.get(i).getApartmentNo();
            Log.d("Number1", no);
        }

        if (apartmentList!=null){
            ListAdapterShoppingCartApartment adapterShoppingCartApartment = new ListAdapterShoppingCartApartment(ShoppingCartActivity.this, R.layout.item_shoppingcart, apartmentList, userId);
            listShoppingCart.setAdapter(adapterShoppingCartApartment);
        }
    }

    public ArrayList<Apartment> getApartmentList(){
        ArrayList<Apartment> apartmentArrayList = new ArrayList<Apartment>();
        ArrayList<String> ShoppingCartItemIdList = DataOperationUser.getShoppingCartItemIdList(userId);
        if (ShoppingCartItemIdList!= null){
            Log.d("shoppingCartid", ShoppingCartItemIdList.toString());
            for (String itemId : ShoppingCartItemIdList){
                Log.d("itemId", itemId);
                Apartment apartment = DataOperationApartment.getApartmentById(itemId);
                Log.d("apartmentInfoadded", apartment.getApartmentNo());
                apartmentArrayList.add(apartment);
            }
        }
        Log.d("apartmentArrayList", Integer.toString(apartmentArrayList.size()));
        Log.d("apartmentArrayList", new Gson().toJson(apartmentArrayList).toString());
        for (Apartment apartment: apartmentArrayList){
            String apno = apartment.getApartmentNo();
            Log.d("apartmentNo1", apno);
        }
        return apartmentArrayList;
    }
}
